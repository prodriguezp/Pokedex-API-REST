package com.pokemon.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pokemon.pokedex.model.Pokemon;
import com.pokemon.pokedex.model.Type_Pokemon;



@Repository
public interface TypeRepositoy extends JpaRepository<Type_Pokemon, Long>{
	
	

}
