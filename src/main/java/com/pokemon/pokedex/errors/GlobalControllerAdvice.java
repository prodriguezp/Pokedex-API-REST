package com.pokemon.pokedex.errors;

import java.time.LocalDateTime;

import org.hibernate.sql.Template;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler({PokemonNotFound.class,NotMorePage.class})
	public ResponseEntity<?> handlerExceptionPokemonNotFound(PokemonNotFound ex){
		TemplateError error = new TemplateError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		TemplateError error = new TemplateError(status, ex.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(status).headers(headers).body(error);
	}
}
