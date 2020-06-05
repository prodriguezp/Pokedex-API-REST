package com.pokemon.pokedex.errors;

public class PokemonNotFound extends Exception{
	
	public static int LIST_EMPTY = 0;
	public static int ID_NOT_FOUND = 1;
	public static int NAME_NOT_FOUND = 2;
	public static int NOT_FOUND_GENERATION = 3;
	
	public PokemonNotFound(int typeException) {
		super(messageException(typeException));

	
	}
	
	private static String messageException(int typeException) {
		if(typeException == LIST_EMPTY) {
			return "List of Pokemons is empty";
		}
		if(typeException == ID_NOT_FOUND) {
			return "Pokemon's id not found";
		}
		if(typeException == NAME_NOT_FOUND) {
			return "Pokemon's name not found";
		}
		if(typeException == NOT_FOUND_GENERATION) {
			return "Generation's id not found";
		}
		
		return "Error";
	};
}

