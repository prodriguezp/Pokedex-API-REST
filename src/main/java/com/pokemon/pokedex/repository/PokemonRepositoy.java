package com.pokemon.pokedex.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pokemon.pokedex.model.Pokemon;



@Repository
public interface PokemonRepositoy extends JpaRepository<Pokemon, Long>{
	
	@Query("SELECT P FROM Pokemon P where P.nombre = :nombre")
	public Pokemon findByName(@Param("nombre")String name);
	
	@Query("SELECT P FROM Pokemon P where (P.type1.typeName = :nameType) or (P.type2.typeName = :nameType)")
	public List<Pokemon> findAllByType(@Param("nameType")String name);

	@Query("SELECT P FROM Pokemon P order by P.ataque desc")
	public List<Pokemon> findAllOrderAttack();

	@Query("SELECT P FROM Pokemon P where P.generacion = :gen")
	public List<Pokemon> findAllByGeneration(@Param("gen")long generation);
	

}
