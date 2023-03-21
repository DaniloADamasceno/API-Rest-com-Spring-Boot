package com.modulo24.resources;

import com.modulo24.domain.User;
import com.modulo24.dto.UserDTO;
import com.modulo24.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/usuarios") //, method = RequestMethod.GET)
public class ResourcesUser {

    @Autowired
    private ServiceUser serviceUser;

    // FIND ALL
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List <UserDTO> >findAll() {
        List<User> userList = serviceUser.findAll();
        // -->  Stream para converter a lista de usuários em uma lista de DTO ⬇️⬇️
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }

    // FIND BY ID
    @RequestMapping(value = "/{id}, method = RequestMethod.GET")
    public ResponseEntity<UserDTO> findAllById(@PathVariable String id) {  // --> PathVariable para receber o ID do usuário
        User userTestId = serviceUser.findAllById(id);
        return ResponseEntity.ok().body(new UserDTO(userTestId));
    }

    //INSERT
    @PostMapping(value = "/{id}")
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO) { // -->  RequestBody para receber o JSON do body
        User userInsert = serviceUser.fromDTO(userDTO);
        userInsert = serviceUser.insert(userInsert);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(userInsert.getId()).toUri();
        return ResponseEntity.created(uri).body(userInsert);

    }

    // DELETE
    @DeleteMapping(value = "/{id}") // -->  DeleteMapping para deletar um usuário
    public ResponseEntity<Void> delete(@PathVariable String id) {
        serviceUser.delete(id);
        return ResponseEntity.noContent().build(); // -->  NoContent para retornar uma resposta vazia com código 204
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable String id) { // --> UPDATE
        User userUpdate = serviceUser.fromDTO(userDTO);
        userUpdate.setId(id);
        userUpdate = serviceUser.update(id, userUpdate);
        return ResponseEntity.ok().body(new UserDTO(userUpdate));
    }
}
