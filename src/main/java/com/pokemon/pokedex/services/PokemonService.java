package com.pokemon.pokedex.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.model.Pokemon;
import com.pokemon.pokedex.repository.PokemonRepositoy;
import com.pokemon.pokedex.services.base.BaseService;

@Service
public class PokemonService extends BaseService<Pokemon,Long, PokemonRepositoy>{

	
	
	public List<Pokemon> findAllByType(String type) {
		return repositorio.findAllByType(type);		
	}
	public List<Pokemon> findAllByGeneration(long generation) {
		return repositorio.findAllByGeneration(generation);		
	}

	public List<Pokemon> findAllOrderAttack() {
		return repositorio.findAllOrderAttack();
	}

	public Pokemon findByName(String name) {
		return repositorio.findByName(name);
	}
	

	
	

}
