/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AuthorizeController
 * Author:   Administrator
 * Date:     19-10-11, 0011 下午 05:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.controller;

import com.wclspringboot.community.community.dto.AccessTokenDTO;
import com.wclspringboot.community.community.dto.GithubUser;
import com.wclspringboot.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.Soundbank;
import javax.swing.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-11, 0011
 * @since 1.0.0
 */
@Controller
public class AuthorizeController {
   @Autowired
   private GithubProvider githubProvider;
   @Value("${github.client.id}")
   private String clientId;
    @Value("${github.client.secret}")
   private String clientSecret;
    @Value("${github.redirect.uri}")
   private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state ){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("96a0b4472f650c2f2ad1");
        accessTokenDTO.setClient_secret("dba7b7a90543b1514c56cf559e22ad94e053c2bc");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accesstoken= githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accesstoken);
        return "index";
    }
}
