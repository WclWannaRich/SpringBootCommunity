/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IndexController
 * Author:   Administrator
 * Date:     19-10-11, 0011 下午 02:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.controller;

import com.sun.deploy.net.cookie.CookieUnavailableException;
import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-11, 0011
 * @since 1.0.0
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
           if(cookie.getName().equals("token")){
               String value = cookie.getValue();
               User byToken = userMapper.findByToken(value);
               if (byToken!= null){
                   request.getSession().setAttribute("user",byToken);
               }
               break;
           }
        }
        return "index";
    }
}
