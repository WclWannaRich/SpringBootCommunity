/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CustomizeErrorCode
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
 * 〈用来引用错误信息〉
 *
 * @author Administrator
 * @create 19-10-18, 0018
 * @since 1.0.0
 */
public interface ICustomizeErrorCode {
    String getMessage() ;
    Integer getCode();
}