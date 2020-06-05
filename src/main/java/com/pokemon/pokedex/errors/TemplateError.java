package com.pokemon.pokedex.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TemplateError {
	private HttpStatus status;
	private String messageError;
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime dataTime;
	public TemplateError(HttpStatus status, String messageError, LocalDateTime dataTime) {
		super();
		this.status = status;
		this.messageError = messageError;
		this.dataTime = dataTime;
	}
	
	
	
}
