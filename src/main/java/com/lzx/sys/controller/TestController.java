package com.lzx.sys.controller;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

}
