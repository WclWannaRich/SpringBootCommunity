/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IndexController
 * Author:   Administrator
 * Date:     19-10-11, 0011 下午 02:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-11, 0011
 * @since 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
