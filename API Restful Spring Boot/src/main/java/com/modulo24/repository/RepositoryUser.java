package com.modulo24.repository;

import com.modulo24.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends MongoRepository<User, String> {
// <User, String>  ->  <Entidade, Tipo do ID da Entidade>
}
