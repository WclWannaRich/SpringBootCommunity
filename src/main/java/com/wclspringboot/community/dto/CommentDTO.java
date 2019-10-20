/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommentDTO
 * Author:   Administrator
 * Date:     19-10-19, 0019 上午 10:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.dto;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-19, 0019
 * @since 1.0.0
 */
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
