package com.pichincha.pruebatec.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.pruebatec.exception.BadRequestException;
import com.pichincha.pruebatec.request.RealizarMovimientoReq;
import com.pichincha.pruebatec.service.MovimientoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movimiento")
public class MovimientoController {
	
	private final MovimientoService movimientoService;
	
	@PostMapping("")
	ResponseEntity<?> realizarMovimiento (@RequestBody RealizarMovimientoReq request) throws BadRequestException{
		return movimientoService.realizarMovimiento(request);
	}
	@GetMapping("/reportes")
	ResponseEntity<?> reporteMovimientos (@RequestParam("fecha_ini") String fechaIni,@RequestParam("fecha_fin") String fechaFin){
		return movimientoService.reporteMovimientos(fechaIni, fechaFin);
	}
	

}
