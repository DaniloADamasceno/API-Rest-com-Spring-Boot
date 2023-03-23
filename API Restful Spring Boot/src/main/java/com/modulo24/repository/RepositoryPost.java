package com.modulo24.repository;

import com.modulo24.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPost extends MongoRepository<Post, String> {
// <Post, String>  ->  <Entidade, Tipo do ID da Entidade>

    //?-----------------------------------   Methods   -----------------------------------------------------------------
    // FIND BY TITLE
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // $regex: ?0 -> 1º parâmetro do método ||  $options: 'i' -> ignora maiúsculas e minúsculas
    List<Post> serachTitle(String text);
}
