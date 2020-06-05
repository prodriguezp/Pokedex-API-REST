package com.pokemon.pokedex.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Type_Pokemon {
	
	@Id
	private long id;
	
	@Column(name = "type_name")
	private String typeName;
	

	public Type_Pokemon(String typeName) {
		super();
		this.typeName = typeName;
	}
	public Type_Pokemon() {

	}
	
	
	
}
