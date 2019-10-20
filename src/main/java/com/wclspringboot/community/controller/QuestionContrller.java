/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuestionContrller
 * Author:   Administrator
 * Date:     19-10-17, 0017 上午 10:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.controller;

import com.wclspringboot.community.dto.QuestionDTO;
import com.wclspringboot.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-17, 0017
 * @since 1.0.0
 */
@Controller
public class QuestionContrller {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable(name = "id") Long id,
                              Model model){
        QuestionDTO questionDTO = questionService.getQuestion(id);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }


}
