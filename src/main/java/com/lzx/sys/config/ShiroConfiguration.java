package com.lzx.sys.config;

import com.lzx.sys.realm.MyRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置
 *
 * @author : lzx
 * 时间 : 2018/5/17.
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 自定义Realm
     * @return
     */
    @Bean(name = "myRealm")
    public MyRealm getRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(getRealm());
        return dwsm;
    }

    /**
     * Shiro过滤器
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
        sffb.setSecurityManager(getDefaultWebSecurityManager());
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        sffb.setLoginUrl("/view/login/login.html");
        // 登录成功后要跳转的连接
        sffb.setSuccessUrl("/user");
        sffb.setUnauthorizedUrl("/403");

        sffb.setFilterChainDefinitionMap(loadFilterChainDefinitionMap());
        return sffb;
    }

    private Map<String,String> loadFilterChainDefinitionMap() {
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/**/*.js","anon");
        filterChainDefinitionMap.put("/view/login.html","anon");
        filterChainDefinitionMap.put("/**","authc");
        return filterChainDefinitionMap;
    }

    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro注解
     * @return
     */
    @Bean(name = "defaultAdvisorAutoProxyCreator")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    /**
     * 开启Shiro注解
     * @return
     */
    @Bean(name = "AuthorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getDefaultWebSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }

}
