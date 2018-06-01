package com.lzx.sys.controller;

import com.baiwang.bop.client.BopException;
import com.baiwang.bop.client.IBopClient;
import com.baiwang.bop.client.ILoginClient;
import com.baiwang.bop.client.impl.BopRestClient;
import com.baiwang.bop.client.impl.PostLogin;
import com.baiwang.bop.request.impl.LoginRequest;
import com.baiwang.bop.request.impl.invoice.common.InvoiceDetails;
import com.baiwang.bop.request.impl.invoice.impl.InvoiceOpenRequest;
import com.baiwang.bop.respose.entity.InvoiceOpenResponse;
import com.baiwang.bop.respose.entity.LoginResponse;
import com.lzx.sys.config.ZookeeperConfig;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/4/20.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    public static Integer maxInt = Integer.MAX_VALUE;

    private ZookeeperConfig zookeeperConfig;

    public TestController(ZookeeperConfig zookeeperConfig) {
        this.zookeeperConfig = zookeeperConfig;
    }

    @GetMapping("/printTest")
    public void printTest(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        try {
            int i=0;
            Date date = null;
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (i<maxInt){
                Thread.sleep(2000);
                date = new Date();
                writer.print("<span>"+sf.format(date)+" : "+i+"</span>");
                writer.flush();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    /**
     * 创建节点测试
     *
     * @param nodeName
     * @return
     */
    @GetMapping("/zookeeperCreateNode")
    public String zookeeperCreateNode(@RequestParam("nodeName") String nodeName) throws IOException, KeeperException, InterruptedException {

        List<String> subNodeListSort = getChildren("root_lock");
        int postfix = 0;
        String subNodeSort = null;
        if (subNodeListSort.size() > 0) {
            subNodeSort = subNodeListSort.get(subNodeListSort.size() - 1);
            postfix = Integer.valueOf(subNodeSort.substring(subNodeSort.lastIndexOf("_") + 1)) + 1;
        }
        Thread root_lock = null;
        for (int i = 0; i < maxInt; i++) {
            Thread.sleep(20000);
             root_lock = new Thread() {
                @Override
                public void run() {
                    ZooKeeper zooKeeper = null;
                    try {
                        zooKeeper = new ZooKeeper(zookeeperConfig.getServerName(), zookeeperConfig.getSessionTimeout(), null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String root_lock = null;
                    try {
                        root_lock = zooKeeper.create("/root_lock/" + nodeName + "_", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("create >>>>>>>>>>>>>>>>>>>>>> " + root_lock);
                    try {
                        List<String> subNodeListSort1 = getChildren("root_lock");
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (subNodeListSort.size() > 0) {
                        try {
                            //zooKeeper.delete("/root_lock/" + subNodeListSort.get(0), -1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("delete >>>>>>>>>>>>>>>>>>>>>> " + subNodeListSort.get(0));
                    }
                }
            };
            root_lock.setDaemon(true);
            root_lock.start();

        }
        System.out.println(root_lock);
        return "正在执行";
    }

    /**
     * 获取子节点
     *
     * @param parentNode 父节点名称
     * @return
     */
    @GetMapping("/getChildren")
    public List<String> getChildren(@RequestParam("parentNode") String parentNode) throws KeeperException, InterruptedException, IOException {
        ZooKeeper zooKeeper = new ZooKeeper(zookeeperConfig.getServerName(), zookeeperConfig.getSessionTimeout(), null);
        List<String> children = zooKeeper.getChildren("/" + parentNode, false);
        //排序
        children.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sort1 = 0;
                int sort2 = 0;
                try {
                    sort1 = Integer.valueOf(o1.substring(o1.lastIndexOf("_") + 1));
                    sort2 = Integer.valueOf(o2.substring(o2.lastIndexOf("_") + 1));
                } catch (NumberFormatException e) {
                    return 0;
                }
                return sort1 - sort2;
            }
        });
        return children;
    }

    public static String url = "http://60.205.83.27/router/rest";             //接口地址
    public static String appkey="10000005";                                   //AppKey
    public static String appSecret="b65025d0-19d2-4841-88f4-ff4439b8da58";    //AppSecrect
    public static String userName="admin_1800000021168";                      //用户名
    public static String password="a123456";                                   //密码
    public static String userSalt="94db610c5c3049df8da3e9ac91390015";         //盐值

    /**
     * 电子发票接口测试
     * @return
     */
    @GetMapping("/electronicInvoice")
    public InvoiceOpenResponse electronicInvoice(){
        String serialNo = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String sellerTaxNo = "91500000747150426A";
        try
        {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setAppkey(appkey);
            loginRequest.setAppSecret(appSecret);
            loginRequest.setUserName(userName);
            loginRequest.setPasswordMd5(password);
            loginRequest.setUserSalt(userSalt);

            ILoginClient loginClient = new PostLogin(url);
            LoginResponse loginResponse = loginClient.login(loginRequest);

            String token=loginResponse.getAccess_token();//获取token

            InvoiceOpenRequest request = new InvoiceOpenRequest();
            request.setSellerTaxNo(sellerTaxNo);
            request.setDeviceType("0");
            request.setOrganizationCode("");
            request.setSerialNo(serialNo);
            request.setInvoiceSpecialMark("00");
            request.setInvoiceTypeCode("026");
            request.setInvoiceTerminalCode("kpyuan002");
            request.setBuyerTaxNo("");
            request.setBuyerName("百望股份有限公司");
            request.setBuyerAddressPhone("");
            request.setBuyerBankAccount("");
            request.setDrawer("wwm");
            request.setChecker("");
            request.setPayee("");
            request.setInvoiceType("0");
            request.setInvoiceListMark("0");
            request.setRedInfoNo("");
            request.setOriginalInvoiceCode("");
            request.setOriginalInvoiceNo("");
            request.setTaxationMode("0");
            request.setDeductibleAmount("");
            request.setInvoiceTotalPrice("200.00");
            request.setInvoiceTotalTax("34.00");
            request.setInvoiceTotalPriceTax("234.00");
            request.setSignatureParameter("0000004282000000");
            request.setTaxDiskNo("");
            request.setTaxDiskKey("");
            request.setTaxDiskPassword("");
            request.setGoodsCodeVersion("");
            request.setConsolidatedTaxRate("");
            request.setNotificationNo("");
            request.setRemarks("备注");

            List<InvoiceDetails> invoiceDetailsList = new ArrayList<InvoiceDetails>();
            InvoiceDetails invoiceDetails = new InvoiceDetails();
            invoiceDetails.setGoodsLineNo("1");
            invoiceDetails.setGoodsLineNature("0");
            invoiceDetails.setGoodsCode("1020101000000000000");
            invoiceDetails.setGoodsExtendCode("");
            invoiceDetails.setGoodsName("停车费用");
            invoiceDetails.setGoodsTaxItem("");
            invoiceDetails.setGoodsSpecification("");
            invoiceDetails.setGoodsUnit("");
            invoiceDetails.setGoodsQuantity("");
            invoiceDetails.setGoodsPrice("");
            invoiceDetails.setGoodsTotalPrice("200.00");
            invoiceDetails.setGoodsTotalTax("34.00");
            invoiceDetails.setGoodsTaxRate("0.17");
            invoiceDetails.setGoodsDiscountLineNo("");
            invoiceDetails.setPriceTaxMark("0");
            invoiceDetails.setVatSpecialManagement("");
            invoiceDetails.setFreeTaxMark("");
            invoiceDetails.setPreferentialMark("0");
            invoiceDetailsList.add(invoiceDetails);

            request.setInvoiceDetailsList(invoiceDetailsList);

            IBopClient client = new BopRestClient(url, appkey, appSecret);

            InvoiceOpenResponse response = 	client.execute(request, token, InvoiceOpenResponse.class);
            return response;
        }
        catch (BopException e)
        {
            System.out.println(e.getErrCode());
            System.out.println(e.getErrMsg());
            System.out.println(e.getSubMessage());
            System.out.println(e.getSubCode());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
