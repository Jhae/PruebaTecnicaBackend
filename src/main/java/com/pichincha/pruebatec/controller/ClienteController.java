package com.pichincha.pruebatec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.pruebatec.entity.Cliente;
import com.pichincha.pruebatec.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@GetMapping("")
	ResponseEntity<List<Cliente>> getClientes(){
		return clienteService.getClientes();
	}
	

}
