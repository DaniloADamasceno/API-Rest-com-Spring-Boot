package com.modulo24.dto;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO author;


    //?----------------------------------------   Constructors   -------------------------------------------------------
    public CommentDTO(String textComment, java.util.Date parse, AuthorDTO author) {
    }

    public CommentDTO(String textComment, Date date, AuthorDTO author) {
        this.text = textComment;
        this.date = date;
        this.author = author;
    }


    //?----------------------------------------   Getters and Setters   ------------------------------------------------
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
}
