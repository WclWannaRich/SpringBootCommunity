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
package com.wclspringboot.community.service;

import com.wclspringboot.community.dto.QuestionDTO;
import com.wclspringboot.community.mapper.QuestionMapper;
import com.wclspringboot.community.mapper.UserMapper;
import com.wclspringboot.community.model.Question;
import com.wclspringboot.community.model.QuestionExample;
import com.wclspringboot.community.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        QuestionExample example = new QuestionExample();
        example.setOrderByClause("id desc");
        List<Question> questions = questionMapper.selectByExample(example);
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
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
        return questions;
    }

    public QuestionDTO getQuestion(Long id){
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO = new QuestionDTO();
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }


    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(Long.valueOf(question.getCreator()));
            question.setViewCount(0);
            question.setCommentCount(0);
            question.setLikeCount(0);
            questionMapper.insert(question);
        }else {
           Question updateQuestion = new Question();
           updateQuestion.setGmtModified(System.currentTimeMillis());
           updateQuestion.setTitle(question.getTitle());
           updateQuestion.setDescription(question.getDescription());
           updateQuestion.setTag(question.getTag());
           questionMapper.updateByPrimaryKey(updateQuestion);
        }
    }

    public void incView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionMapper.incView(question);
    }

    public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regexpTag);

        List<Question> questions = questionMapper.selectRelated(question);
        List<QuestionDTO> questionDTOS = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q, questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOS;
    }
}
