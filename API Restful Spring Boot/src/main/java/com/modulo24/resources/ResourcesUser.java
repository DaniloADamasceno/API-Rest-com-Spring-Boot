package com.modulo24.resources;

import com.modulo24.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios") //, method = RequestMethod.GET)
public class ResourcesUser {

    @GetMapping
    public ResponseEntity<List <User> >findAll() {
        User userTesteInicial =  new User("1", "Usuario Teste", "testeUSUARIO@test.com.br");
        User userTesteInicial2 =  new User("2", "Usuario Teste TWO", "testUsuarioTWO@test.com.br");

        List<User> userList = new ArrayList<>();

        // --->  Adicionando os usuários na lista de Forma Unitaria

        //userList.add(userTesteInicial);
        //userList.add(userTesteInicial2);
        // --->  Adicionando os usuários na lista de Forma com mais de um elemento
        userList.addAll(Arrays.asList(userTesteInicial, userTesteInicial2));
        return ResponseEntity.ok().body(userList);
    }
}
