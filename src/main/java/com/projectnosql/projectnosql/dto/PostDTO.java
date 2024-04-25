package com.projectnosql.projectnosql.dto;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    private String title;
    private String body;
    private Date date;
    private String authorId;
    public PostDTO() {
    }

    // Construtor com todos os campos
    public PostDTO(String title, String body, Date date, String authorId) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.authorId = authorId;
    }

    // Getters e setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
