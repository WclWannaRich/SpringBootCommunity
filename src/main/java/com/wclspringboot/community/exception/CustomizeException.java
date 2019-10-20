/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CustomizeException
 * Author:   Administrator
 * Date:     19-10-18, 0018 下午 04:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用来传递错误信息〉
 *
 * @author Administrator
 * @create 19-10-18, 0018
 * @since 1.0.0
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
