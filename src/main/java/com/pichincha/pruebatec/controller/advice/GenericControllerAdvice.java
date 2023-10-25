package com.pichincha.pruebatec.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pichincha.pruebatec.exception.BadRequestException;
import com.pichincha.pruebatec.response.GenErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GenericControllerAdvice {
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<GenErrorResponse> handleUnexpectedError(BadRequestException e){
		log.error("Operacion errada",e);
		GenErrorResponse response = GenErrorResponse.builder().message(e.getMessage()).build();
		return ResponseEntity.internalServerError().body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenErrorResponse> handleUnexpectedError(Exception e){
		log.error("Error Inesperado",e);
		String message = "Se ha presentado un problema durante la operacion.";
		GenErrorResponse response = GenErrorResponse.builder().message(message).build();
		return ResponseEntity.internalServerError().body(response);
	}

}
