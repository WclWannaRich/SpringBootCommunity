/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProfileController
 * Author:   Administrator
 * Date:     19-10-16, 0016 下午 02:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.Question;
import com.wclspringboot.community.community.model.User;
import com.wclspringboot.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-16, 0016
 * @since 1.0.0
 */
@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Question> list = questionService.list();
        PageInfo<Question> pageInfo = new PageInfo<>(list);

        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }

        if(action.equals("questions")){
            model.addAttribute("section","questions");
            model.addAttribute("questions",pageInfo);
            model.addAttribute("sectionName","我的帖子");
        }

        if (action.equals("message")){
            model.addAttribute("section","messages");
            model.addAttribute("sectionName","我的消息");
        }

        return "profile";

    }
}
