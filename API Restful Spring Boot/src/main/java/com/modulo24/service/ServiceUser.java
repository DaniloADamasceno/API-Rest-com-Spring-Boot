package com.modulo24.service;

import com.modulo24.domain.User;
import com.modulo24.dto.UserDTO;
import com.modulo24.repository.RepositoryUser;
import com.modulo24.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    //?-----------------------------------   Methods   -----------------------------------------------------------------
    // FIND ALL
    public List<User> findAll() {  //-->  Método que retorna todos os usuários
        return repositoryUser.findAll();
    }

    // FIND ALL BY ID
    public User findAllById(String id) { //-->  Método que retorna todos os usuários através do ID
        User user = repositoryUser.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("⚠️ User not found / Usuário não encontrado ⚠️");
        }
        return user;
    }

    // INSERT
    public User insert(User userInsert) {  //-->  Método que INSERT um usuário
        return repositoryUser.insert(userInsert);
    }

    // DELETE
    public void delete(String id) { //-->  Método que DELETE um usuário
        findAllById(id);
        repositoryUser.deleteById(id);
    }

    // FROM DTO
    public User fromDTO(UserDTO userDTO) { //-->  Método que converte um DTO em um usuário
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    // UPDATE
    public User update(@PathVariable String id, @RequestBody User userUpdate) {
        User newUserUpdate = findAllById(userUpdate.getId());
        updateData(newUserUpdate, userUpdate);
        return repositoryUser.save(newUserUpdate);
    }

    //? -----------------------------------   Private Methods   --------------------------------------------------------
    private void updateData(User newUser, User userUpdate) {    //-->  Método que atualiza os dados do usuário
        newUser.setName(userUpdate.getName());                  //-->  Atualiza o nome do usuário
        newUser.setEmail(userUpdate.getEmail());                //-->  Atualiza o email do usuário
    }
}

