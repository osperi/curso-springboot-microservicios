package com.cursosdedesarrollo.microserviciospring.repository;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

}
