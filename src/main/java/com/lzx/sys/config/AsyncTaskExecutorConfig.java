package com.lzx.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/5/9.
 */
@Configuration
public class AsyncTaskExecutorConfig {

    @Bean
    public AsyncTaskExecutor asyncTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Anno-Executor");
        executor.setMaxPoolSize(10);
        return executor;
    }

}
