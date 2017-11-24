package com.hello.model;

import java.util.Date;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/24 11:36
 * desc
 */

public class Post {
    private long post_id;
    private long userid;
    private String title;
    private String content;
    private Date createdtime;

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdtime=" + createdtime +
                '}';
    }
}
