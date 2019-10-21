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
package com.wclspringboot.community.service;

import com.wclspringboot.community.mapper.UserMapper;
import com.wclspringboot.community.model.User;
import com.wclspringboot.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            User userupdate = users.get(0);
            userupdate.setGmtModified(System.currentTimeMillis());
            userupdate.setAccountId(user.getAccountId());
            userupdate.setName(user.getName());
            userupdate.setToken(user.getToken());
            userMapper.updateByPrimaryKey(userupdate);
        }
    }
}
