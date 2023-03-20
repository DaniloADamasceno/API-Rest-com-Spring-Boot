package com.modulo24.configuration;

import com.modulo24.domain.User;
import com.modulo24.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    //?------------------------   Injeção de Dependência   ---------------------------------------------------------
    @Autowired
    private RepositoryUser repositoryUser;


    @Override
    public void run(String... args) throws Exception {

        //?------------------------   Criação de uns USUÀRIOS para teste   ---------------------------------------------
        repositoryUser.deleteAll(); // Deleta todos os usuários do banco de dados

        User userNina = new User(null, "Nina", "Nina@Hotmail.co");
        User userFred = new User(null, "Frederico", "Frederico@yahoo.com");
        User userSnow = new User(null, "Snow", "Nain@Boll.com");

        repositoryUser.saveAll(Arrays.asList(userNina, userFred, userSnow)); // Salva os usuários no banco de dados


    }
}
