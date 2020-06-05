package com.pokemon.pokedex.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.pokemon.pokedex.dto.PokemonDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pokemon {
	@Id
	long id;
	String nombre;
	long total;
	
	long hp;
	
	long ataque;
	long defensa;
	long spataque;
	long spdefensa;
	
	long velocidad;
	long generacion;

	@OneToOne
	Type_Pokemon type1;
	@OneToOne
	Type_Pokemon type2;

	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

	public Pokemon(long id, String nombre, long hp, long ataque, long defensa, long spataque, long spdefense,
			long velocidad, long generacion,Type_Pokemon type1, Type_Pokemon type2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.hp = hp;
		this.ataque = ataque;
		this.defensa = defensa;
		this.spataque = spataque;
		this.spdefensa = spdefense;
		this.velocidad = velocidad;
		this.generacion = generacion;
		this.type1 = type1;
		this.type2 = type2;
	}
	


}
