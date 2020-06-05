package com.pokemon.pokedex.dto;



import com.pokemon.pokedex.model.Pokemon;
import com.pokemon.pokedex.model.Type_Pokemon;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter @Setter
public class PokemonDTO {

	
	private String nombre;
	private String type1;
	private String type2;
	private long total;
	private long hp;
	private long ataque;
	private long defensa;
	private long spataque;
	private long spdefensa;
	private long velocidad;
	private long generacion;
	
	
	
}
