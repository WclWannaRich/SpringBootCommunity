/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuestionService
 * Author:   Administrator
 * Date:     19-10-14, 0014 下午 01:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.service;

import com.wclspringboot.community.community.dto.QuestionDTO;
import com.wclspringboot.community.community.mapper.QuestionMapper;
import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.Question;
import com.wclspringboot.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-14, 0014
 * @since 1.0.0
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> list(){
        List<Question> questionList = questionMapper.list();
        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            question.setUser(user);
        }
//        List<QuestionDTO> questionDTOList  = new ArrayList<>();
//        for (Question question : questionList) {
//            User user = userMapper.findById(question.getCreator());
//            QuestionDTO questionDTO = new QuestionDTO();
//            BeanUtils.copyProperties(question,questionDTO);
//            questionDTO.setUser(user);
//            questionDTOList.add(questionDTO);
//        }
//        return questionDTOList;
        return questionList;
    }

    public QuestionDTO getQuestion(Integer id){
        Question question = questionMapper.getQuestion(id);
        QuestionDTO questionDTO = new QuestionDTO();
        User user = userMapper.findById(question.getCreator());
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }


    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(Long.valueOf(question.getCreator()));
            questionMapper.create(question);
        }else {
            question.setGmtModified(Long.valueOf(question.getCreator()));
            questionMapper.update(question);
        }
    }
}
