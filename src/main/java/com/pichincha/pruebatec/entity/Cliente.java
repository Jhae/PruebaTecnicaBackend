package com.pichincha.pruebatec.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Data
@Entity
@Table(name = "ph_cliente")
public class Cliente extends Persona{
	@JsonIgnore
	private String contrasena;
	private Boolean estado;

	@OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
	private List<Cuenta> cuentas;
}
