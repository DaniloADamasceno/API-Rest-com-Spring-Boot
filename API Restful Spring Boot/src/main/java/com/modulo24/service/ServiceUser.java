package com.modulo24.service;

import com.modulo24.domain.User;
import com.modulo24.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    //?-----------------------------------   Methods   -----------------------------------------------------------------
    public List<User> findAll() {  //                          -->  Método que retorna todos os usuários
        return repositoryUser.findAll();
    }
}
