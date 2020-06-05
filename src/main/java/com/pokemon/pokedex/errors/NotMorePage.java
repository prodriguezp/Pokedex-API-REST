package com.pokemon.pokedex.errors;

public class NotMorePage extends Exception{
	public NotMorePage() {
		super("No hay mas paginas de pokemon");
	}
}
