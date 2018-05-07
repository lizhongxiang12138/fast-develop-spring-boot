package com.lzx.sys.config;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/4/20.
 */
@Component
public class ZookeeperConfig {

    @Value("${lzx.zookeeper.server}")
    private String serverName;
    @Value("${lzx.zookeeper.sessionTimeout}")
    private Integer sessionTimeout;

    public String getServerName() {
        return serverName;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }
}
