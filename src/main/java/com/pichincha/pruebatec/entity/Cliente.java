package com.pichincha.pruebatec.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "cliente")
public class Cliente {
	
	private String contrasena;
	private Boolean estado;

	@OneToMany(mappedBy = "cliente")
	private List<Cuenta> cuentas;
}
