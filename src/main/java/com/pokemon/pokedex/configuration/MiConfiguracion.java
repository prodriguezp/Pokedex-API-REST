package com.pokemon.pokedex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MiConfiguracion {	
	
	@Bean 
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
