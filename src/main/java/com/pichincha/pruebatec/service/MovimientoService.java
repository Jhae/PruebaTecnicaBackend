package com.pichincha.pruebatec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pichincha.pruebatec.exception.BadRequestException;
import com.pichincha.pruebatec.request.RealizarMovimientoReq;
import com.pichincha.pruebatec.response.ReporteMovimientoDto;

public interface MovimientoService {
	
	ResponseEntity<?> realizarMovimiento(RealizarMovimientoReq request) throws BadRequestException; 
	
	ResponseEntity<List<ReporteMovimientoDto>> reporteMovimientos(String fecha_ini, String fecha_fin);

}
