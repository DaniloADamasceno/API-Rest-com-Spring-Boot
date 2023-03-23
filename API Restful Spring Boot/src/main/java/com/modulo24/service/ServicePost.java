package com.modulo24.service;

import com.modulo24.domain.Post;
import com.modulo24.repository.RepositoryPost;
import com.modulo24.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePost {

    @Autowired
    private RepositoryPost repositoryPost;

    //?-----------------------------------   Methods   -----------------------------------------------------------------
    // FIND ALL BY ID
    public Post findAllById(String id) { //-->  Método que retorna todos os usuários através do ID
        Optional<Post> userOptional = repositoryPost.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("⚠️ Object not found  / Objeto não encontrado ⚠️"));
    }

    // FIND BY TITLE
    public List<Post> findByTitle(String text) { //  --> Método que retorna todos os usuários através do Título do Post
       return repositoryPost.serachTitle(text);
    }

}

