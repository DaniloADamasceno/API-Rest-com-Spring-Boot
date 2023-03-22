package com.modulo24.domain;

import com.modulo24.dto.AuthorDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "post")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Date date;
    private String title;
    private String body;

    private AuthorDTO authorDTO;


    //?----------------------------------------   Constructors   -------------------------------------------------------
    public Post() {
    }

    public Post(String id, Date date, String title, String body, AuthorDTO authorDTO) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.authorDTO = authorDTO;
    }

    //?----------------------------------------   Getters and Setters   ------------------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

//?----------------------------------------   HashCode and Equals   ------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return getId().equals(post.getId()) && getDate().equals(post.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }
}
