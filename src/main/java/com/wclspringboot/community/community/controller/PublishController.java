/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PublishController
 * Author:   Administrator
 * Date:     19-10-13, 0013 下午 01:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.controller;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import com.wclspringboot.community.community.mapper.QuestionMapper;
import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.Question;
import com.wclspringboot.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-13, 0013
 * @since 1.0.0
 */
@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title", required=false) String title,
                            @RequestParam(value = "description", required=false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            HttpServletRequest request,
                            Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title == null && title =="" ){
            model.addAttribute("error","标题不可以为空");
        }

        if(description == null && description =="" ){
            model.addAttribute("error","问题描述不可以为空");
        }

        if(tag == null && tag =="" ){
            model.addAttribute("error","标签不可以为空");
        }
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String value = cookie.getValue();
                user = userMapper.findByToken(value);
                if (user!= null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(Long.valueOf(question.getCreator()));
        questionMapper.create(question);
        return "redirect:/";
    }
}

