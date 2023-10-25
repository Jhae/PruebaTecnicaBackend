package com.pichincha.pruebatec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pichincha.pruebatec.entity.Cliente;

public interface ClienteService {
	
	ResponseEntity<List<Cliente>> getClientes();

}
