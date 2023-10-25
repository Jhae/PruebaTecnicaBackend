package com.pichincha.pruebatec.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pichincha.pruebatec.entity.Cliente;
import com.pichincha.pruebatec.repository.ClienteRepository;
import com.pichincha.pruebatec.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Override
	public ResponseEntity<List<Cliente>> getClientes() {
		
		return ResponseEntity.ok(clienteRepository.findAll());
	}

}
