package com.fpds.entity;

import java.util.Date;

import org.springframework.util.Assert;

public class QualityFocus {
    private String id;

    private String title;

    private Integer type;

    private Integer platform;

    private Date publishTime;

    private Date createTime;

    private String thumbnail;

    private Integer category;

    private Integer is;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIs() {
        return is;
    }

    public void setIs(Integer is) {
        this.is = is;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    public void check(){
    	Assert.notNull(title,"不能为空");
    	Assert.notNull(type,"不能为空");
    	Assert.notNull(platform,"不能为空");
    	Assert.notNull(publishTime,"不能为空");
    	Assert.notNull(createTime,"不能为空");
    	Assert.notNull(category,"不能为空");
    	Assert.notNull(content,"不能为空");
    }
}