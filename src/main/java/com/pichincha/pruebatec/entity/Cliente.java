package com.pichincha.pruebatec.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona{
	@Getter @Setter
	private String contrasena;
	@Getter @Setter
	private Boolean estado;

	@OneToMany(mappedBy = "cliente")
	private List<Cuenta> cuentas;
}
