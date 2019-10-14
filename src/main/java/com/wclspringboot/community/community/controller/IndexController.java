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
import com.wclspringboot.community.community.dto.QuestionDTO;
import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.Question;
import com.wclspringboot.community.community.model.User;
import com.wclspringboot.community.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
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
        List<QuestionDTO> questionlist = questionService.list();
        model.addAttribute("questions",questionlist);
        return "index";
    }


}
