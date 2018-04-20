package com.lzx.sys.controller;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/4/20.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private ZooKeeper zooKeeper;

    public TestController(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    /**
     * 创建节点测试
     * @param nodeName
     * @return
     */
    @GetMapping("/zookeeperCreateNode")
    public String zookeeperCreateNode(@RequestParam("nodeName")String nodeName,@RequestParam("serverName")String serverName) throws IOException, KeeperException, InterruptedException {
        String root_lock = zooKeeper.create("/"+nodeName, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(root_lock);
        return  root_lock;
    }

}
