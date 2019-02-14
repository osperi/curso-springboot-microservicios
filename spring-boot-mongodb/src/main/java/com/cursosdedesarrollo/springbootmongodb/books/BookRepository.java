package com.cursosdedesarrollo.springbootmongodb.books;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByTitleContainingOrderByTitle(String titleContains);
    List<Book> findByTitleContaining(String titleContains);
    List<Book> findBooksByAuthorNamesContaining(String authorName);
    List<Book> findBooksBySubjectsContaining(String subject);

}
