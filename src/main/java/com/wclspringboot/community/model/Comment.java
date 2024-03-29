package com.wclspringboot.community.model;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.ID
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.parent_id
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.type
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.commentator
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Long commentator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_create
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Long gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_modified
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Long gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.like_count
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private Integer likeCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.ID
     *
     * @return the value of comment.ID
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.ID
     *
     * @param id the value for comment.ID
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.parent_id
     *
     * @return the value of comment.parent_id
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.parent_id
     *
     * @param parentId the value for comment.parent_id
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.type
     *
     * @return the value of comment.type
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.type
     *
     * @param type the value for comment.type
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.commentator
     *
     * @return the value of comment.commentator
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Long getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.commentator
     *
     * @param commentator the value for comment.commentator
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_create
     *
     * @return the value of comment.gmt_create
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_create
     *
     * @param gmtCreate the value for comment.gmt_create
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_modified
     *
     * @return the value of comment.gmt_modified
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_modified
     *
     * @param gmtModified the value for comment.gmt_modified
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.like_count
     *
     * @return the value of comment.like_count
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.like_count
     *
     * @param likeCount the value for comment.like_count
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbggenerated Sat Oct 19 14:30:46 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}