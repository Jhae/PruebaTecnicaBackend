package com.pichincha.pruebatec.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class Persona {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombres;
	private String genero;
	private String edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	
}
