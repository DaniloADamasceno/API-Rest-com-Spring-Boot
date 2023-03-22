package com.modulo24.configuration;

import com.modulo24.domain.Post;
import com.modulo24.domain.User;
import com.modulo24.dto.AuthorDTO;
import com.modulo24.repository.RepositoryPost;
import com.modulo24.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    SimpleDateFormat sFormatBR = new SimpleDateFormat("dd/MM/yyyy");
    //sFormatBR.setTimeZone(TimeZone.getTimeZone("GMT"));


    //?---------------------------------------   Injeção de Dependência   ----------------------------------------------
    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositoryPost repositoryPost;


    @Override
    public void run(String... args) throws Exception {

        //?--------------------------------   Criação de uns USUÀRIOS para teste   -------------------------------------
        repositoryUser.deleteAll(); // Deleta todos os usuários do banco de dados antes de criar outros novos usuários

        User userNina   = new User(null, "Nina", "Nina@Hotmail.co");
        User userFred   = new User(null, "Frederico", "Frederico@yahoo.com");
        User userSnow   = new User(null, "Snow", "Nain@Boll.com");
        User userMalu   = new User(null, "Malu", "malu@yahoo.com.br");
        User userMaggie = new User(null, "Maggie", "maggie@hotmail.com");

        repositoryUser.saveAll(Arrays.asList(userNina, userFred, userSnow, userMaggie, userMalu)); // Salva os usuários no banco de dados


        //?------------------------------------   Criação de uns POSTS para teste   ------------------------------------

        repositoryPost.deleteAll(); // Deleta todos os posts do banco de dados antes de criar outros novos posts

        Post post1 = new Post(null, sFormatBR.parse("10/05/2021"), "Partiuuuuuu", "Estou indo viajar, não sei quando irei retornar ", new AuthorDTO(userNina));
        Post post2 = new Post(null, sFormatBR.parse("13/02/2022"), "Fome de dragão", "Acho que a Fome bateu aqui ...", new AuthorDTO(userSnow));
        Post post3 = new Post(null, sFormatBR.parse("08/08/2020"), "Beleza", "Fala meus consagrados , e ai como vão ??", new AuthorDTO(userFred));
        Post post4 = new Post(null, sFormatBR.parse("13/12/2021"), "Bom dia, todo dia", "Todo dia e dia de se fazer um bom dia.", new AuthorDTO(userMaggie));
        Post post5 = new Post(null, sFormatBR.parse("21/05/2022"), "Voltandoooooo", "Acordei feliz hoje, estou retornando hoje de Viajem", new AuthorDTO(userNina));
        Post post6 = new Post(null, sFormatBR.parse("21/05/2022"), "mas ja ", "Mas ja , Achei que iria fica ai por mais tempo ", new AuthorDTO(userMalu));
        Post post7 = new Post(null, sFormatBR.parse("21/05/2022"), "Rolezando", "Aproveita que esta voltando é vamos logo marcar aquele rolezinho maroto", new AuthorDTO(userSnow));

        // SALVAR OS POSTS NO BANCO DE DADOS
        repositoryPost.saveAll(Arrays.asList(post1, post2, post3, post4, post5, post6, post7));


        //?------------------------------------   Associação de Posts aos respectivos Usuarios   -----------------------
        userNina.getPosts().addAll(Arrays.asList(post1, post5));
        userFred.getPosts().addAll(Arrays.asList(post3));
        userSnow.getPosts().addAll(Arrays.asList(post2, post7));
        userMaggie.getPosts().addAll(Arrays.asList(post4));


        //?------------------------------------   Salva os usuários com os posts associados   ---------------------------
        repositoryUser.save(userNina);
        repositoryUser.save(userFred);
        repositoryUser.save(userSnow);
        repositoryUser.save(userMaggie);
        repositoryUser.save(userMalu);



    }
}
