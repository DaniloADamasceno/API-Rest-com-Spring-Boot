package com.modulo24.dto;

import com.modulo24.domain.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;


    //?----------------------------------------   Constructors   -------------------------------------------------------
    public UserDTO() {
    }

    public UserDTO(User userDTO) {
        id = userDTO.getId();
        name = userDTO.getName();
        email = userDTO.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
