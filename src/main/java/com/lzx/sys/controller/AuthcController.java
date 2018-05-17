package com.lzx.sys.controller;

import com.lzx.sys.dto.ReturnDTO;
import com.lzx.sys.entity.AuthUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户认证controller
 *
 * @author : lzx
 * 时间 : 2018/5/17.
 */
@RestController
@RequestMapping("/authc")
public class AuthcController {

    @PostMapping("/doLogin")
    public void doLogin(@RequestBody AuthUser authUser, HttpServletResponse response){
        ReturnDTO<AuthUser> returnDTO = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(authUser.getUserAccount(), authUser.getUserPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            returnDTO = new ReturnDTO<>(ReturnDTO.FAIL,"用户名或密码错误",null,null);
        }
    }

}
