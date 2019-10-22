/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TagDTO
 * Author:   Administrator
 * Date:     19-10-22, 0022 下午 03:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wclspringboot.community.dto;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-10-22, 0022
 * @since 1.0.0
 */
public class TagDTO {
    private String categoryName;
    private List<String> tags;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", tags=" + tags +
                '}';
    }
}
