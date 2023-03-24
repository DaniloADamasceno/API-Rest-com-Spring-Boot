package com.modulo24.domain;

import com.modulo24.dto.AuthorDTO;

import java.util.Date;

public class PostBuilder {
    private String id;
    private Date parse;
    private String title;
    private String body;
    private AuthorDTO authorDTO;
    private Date date;

    public PostBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PostBuilder setParse(Date parse) {
        this.parse = parse;
        return this;
    }

    public PostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public PostBuilder setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
        return this;
    }

    public PostBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public Post createPost() {
        return new Post(id, parse, title, body, authorDTO);
    }
}