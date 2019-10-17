package com.wclspringboot.community.community.mapper;

import com.wclspringboot.community.community.model.Question;
import org.apache.ibatis.annotations.*;

import javax.naming.Name;
import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();

    @Select("select * from question where id = #{id}")
    Question getQuestion(@Param("id") Integer id);

    @Update("update question set title = #{title},description =  #{description},tag = #{tag},gmt_modified = #{gmtModified} where id = #{id}")
    void update(Question question);
}
