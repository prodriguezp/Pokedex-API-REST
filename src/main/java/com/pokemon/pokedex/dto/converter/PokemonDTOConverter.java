package com.pokemon.pokedex.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pokemon.pokedex.dto.PokemonDTO;
import com.pokemon.pokedex.model.Pokemon;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PokemonDTOConverter {

	private ModelMapper modelMapper = new ModelMapper();
	
	
	public PokemonDTO convertToDTO(Pokemon p) {
		return modelMapper.map(p, PokemonDTO.class);
	}
}
