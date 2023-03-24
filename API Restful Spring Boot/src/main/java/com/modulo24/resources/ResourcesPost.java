package com.modulo24.resources;

import com.modulo24.domain.Post;
import com.modulo24.dto.UserDTO;
import com.modulo24.resources.util.URL;
import com.modulo24.service.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.OptionalLong;


@RestController
@RequestMapping(value = "/posts") //, method = RequestMethod.GET)
public class ResourcesPost {

    @Autowired
    private ServicePost servicePost;

    //?-----------------------------------   Methods   -----------------------------------------------------------------
    // FIND BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findAllById(@PathVariable String id) {                  // --> PathVariable para receber o ID do usuário
        Post postAllById = servicePost.findAllById(id);
        return ResponseEntity.ok().body(postAllById);
    }

    // FIND BY TITLE
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {  // --> RequestParam para dizer que esse parâmetro é opcional
        text = URL.decodeParam(text); // --> Decodifica o texto
        List<Post> postAllById = servicePost.findByTitle(text);
        return ResponseEntity.ok().body(postAllById);
    }

    // FULL SEARCH
    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,               // --> Primeiro parametro do método é o texto
            @RequestParam(value = "minDate", defaultValue = "") String minDate,         // --> Segndo parametro do método é a data mínima
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {       // --> Terceiro parametro do método é a data máxima
        text = URL.decodeParam(text);                                                   // --> Decodifica o texto
        Date min = URL.convertDate(minDate, new Date(0L));                        // --> Converte a data mínima
        Date max = URL.convertDate(maxDate, new Date());                                // --> Converte a data máxima

        List<Post> postAllById = servicePost.fullSearch(text, min, max);
        return ResponseEntity.ok().body(postAllById);
    }
}
