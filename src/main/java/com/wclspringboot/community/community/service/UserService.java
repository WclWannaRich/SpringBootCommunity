/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     19-10-17, 0017 下午 04:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.service;

import com.wclspringboot.community.community.mapper.UserMapper;
import com.wclspringboot.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-17, 0017
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrInsert(User user){
        User userByAccountId = userMapper.findByAccountId(user.getAccountId());
        if(userByAccountId == null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            userByAccountId.setGmtModified(System.currentTimeMillis());
            userByAccountId.setAccountId(user.getAccountId());
            userByAccountId.setName(user.getName());
            userByAccountId.setToken(user.getToken());
            userMapper.update(userByAccountId);
        }
    }
}
