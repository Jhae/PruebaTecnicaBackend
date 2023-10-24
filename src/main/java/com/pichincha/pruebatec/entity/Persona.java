package com.pichincha.pruebatec.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@MappedSuperclass
public class Persona {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String genero;
	private String edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	
}
