package com.modulo24.dto;

import com.modulo24.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AutorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;


    //?----------------------------------------   Constructors   -------------------------------------------------------
    public AutorDTO() {
    }

    public AutorDTO(User userDTO) {
        id = userDTO.getId();
        name = userDTO.getName();
    }


    //?----------------------------------------   Getters and Setters   ------------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
