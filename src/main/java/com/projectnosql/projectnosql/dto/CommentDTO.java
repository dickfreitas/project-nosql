package com.projectnosql.projectnosql.dto;

import com.projectnosql.projectnosql.domain.Post;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private String text;
    private Date date;
    private String authorId;
    private String postId;

    public CommentDTO() {
    }

    public CommentDTO(String text, Date date, String author, String post) {
        this.text = text;
        this.date = date;
        this.authorId = author;
        this.postId = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String author) {
        this.authorId = author;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String post) {
        this.postId = post;
    }
}
