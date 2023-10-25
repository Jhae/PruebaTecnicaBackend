package com.pichincha.pruebatec.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "ph_cliente")
public class Cliente extends Persona{
	private String contrasena;
	private Boolean estado;

	@OneToMany(mappedBy = "cliente")
	private List<Cuenta> cuentas;
}
