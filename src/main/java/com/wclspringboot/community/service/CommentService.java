/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommentService
 * Author:   Administrator
 * Date:     19-10-19, 0019 上午 09:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.service;

import com.wclspringboot.community.dto.CommentDTO;
import com.wclspringboot.community.enums.CommentTypeEnum;
import com.wclspringboot.community.mapper.CommentMapper;
import com.wclspringboot.community.mapper.QuestionMapper;
import com.wclspringboot.community.mapper.UserMapper;
import com.wclspringboot.community.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-19, 0019
 * @since 1.0.0
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insert(Comment comment){
//        if(comment.getParentId() == null||comment.getParentId() == 0){
//            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
//        }
//
//        if (comment.getType() == null|| CommentTypeEnum.isExist(comment.getType())){
//            throw  new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
//        }
//        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
//            //回复评论
//            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
//            if (dbComment == null){
//                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
//            }
//            commentMapper.insert(comment);
//        }else{
//            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
//            if (question == null){
//                throw  new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
//            }
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionMapper.incCommentCount(question);
 //       }
    }


    public List<CommentDTO> listByQuestionId(Long id) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(CommentTypeEnum.QUESTION.getType());
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        if (comments.size() == 0){
            return new ArrayList<>();
        }
        //获取去重的评论人
        Set<Long> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(commentators);

        //获取评论人并且转换成map
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users  = userMapper.selectByExample(userExample);
        Map<Long,User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(),user -> user));


        //转换comment 为 commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;
    }
}
