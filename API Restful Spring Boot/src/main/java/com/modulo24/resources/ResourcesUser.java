package com.modulo24.resources;

import com.modulo24.domain.User;
import com.modulo24.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/usuarios") //, method = RequestMethod.GET)
public class ResourcesUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping
    public ResponseEntity<List <User> >findAll() {
        List<User> userList = serviceUser.findAll();
        return ResponseEntity.ok().body(userList);
    }
}
