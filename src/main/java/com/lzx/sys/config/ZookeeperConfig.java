package com.lzx.sys.config;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/4/20.
 */
@Configuration
public class ZookeeperConfig {

    @Value("${lzx.zookeeper.server}")
    private String serverName;
    @Value("${lzx.zookeeper.sessionTimeout}")
    private Integer sessionTimeout;

    @Bean
    public ZooKeeper zooKeeper() throws IOException {
        return new ZooKeeper(serverName, sessionTimeout, null);
    }
}
