package com.projectnosql.projectnosql.domain;

import com.projectnosql.projectnosql.dto.AuthorDTO;
import com.projectnosql.projectnosql.dto.CommentDTO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document
public class Comment  implements Serializable {
    @Field("commentText")
    private String text;

    private Date date;

    private AuthorDTO author;

    private Post post;

    public Comment() {
    }

    public Comment(String text, Date date, AuthorDTO author, Post post) {
        this.text = text;
        this.date = date;
        this.author = author;
        this.post = post;
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
