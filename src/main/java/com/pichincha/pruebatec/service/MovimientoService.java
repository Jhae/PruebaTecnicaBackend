package com.pichincha.pruebatec.service;

import org.springframework.http.ResponseEntity;

import com.pichincha.pruebatec.exception.BadRequestException;
import com.pichincha.pruebatec.request.RealizarMovimientoReq;

public interface MovimientoService {
	
	ResponseEntity<?> realizarMovimiento(RealizarMovimientoReq request) throws BadRequestException; 

}
