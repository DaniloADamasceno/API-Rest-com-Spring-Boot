package com.modulo24.resources;

import com.modulo24.domain.User;
import com.modulo24.dto.UserDTO;
import com.modulo24.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/usuarios") //, method = RequestMethod.GET)
public class ResourcesUser {

    @Autowired
    private ServiceUser serviceUser;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List <UserDTO> >findAll() {
        List<User> userList = serviceUser.findAll();
        // -->  Stream para converter a lista de usuários em uma lista de DTO ⬇️⬇️
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }

    @RequestMapping(value = "/{id}, method = RequestMethod.GET")
    public ResponseEntity<UserDTO> findAllById(@PathVariable String id) {  // --> PathVariable para receber o ID do usuário
        User userTestId = serviceUser.findAllById(id);
        return ResponseEntity.ok().body(new UserDTO(userTestId));
    }
}
