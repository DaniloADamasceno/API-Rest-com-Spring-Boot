package com.modulo24.repository;

import com.modulo24.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPost extends MongoRepository<Post, String> {
// <Post, String>  ->  <Entidade, Tipo do ID da Entidade>
}
