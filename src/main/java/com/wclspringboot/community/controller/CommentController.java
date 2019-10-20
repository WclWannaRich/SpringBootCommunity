/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommentController
 * Author:   Administrator
 * Date:     19-10-19, 0019 上午 09:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.controller;

import com.wclspringboot.community.dto.CommentDTO;
import com.wclspringboot.community.dto.ResultDTO;
import com.wclspringboot.community.exception.CustomizeErrorCode;
import com.wclspringboot.community.model.Comment;
import com.wclspringboot.community.model.User;
import com.wclspringboot.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-19, 0019
 * @since 1.0.0
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment  = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setType(commentDTO.getType());
        comment.setContent(commentDTO.getContent());

        comment.setCommentator(user.getId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
