package com.cursosdedesarrollo.springbootmongodb.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface UserRepository extends MongoRepository<User, String> {

    /*List<User> findByTitleContainingOrderByTitle(String titleContains);
    List<User> findByTitleContaining(String titleContains);
    List<User> findUsersByAuthorNamesContaining(String authorName);
    List<User> findUsersBySubjectsContaining(String subject);*/

}
