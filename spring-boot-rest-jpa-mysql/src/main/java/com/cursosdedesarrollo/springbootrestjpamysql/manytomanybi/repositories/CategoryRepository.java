package com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.repositories;

import com.cursosdedesarrollo.springbootrestjpamysql.Note;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Category;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
