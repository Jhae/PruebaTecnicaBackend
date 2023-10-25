package com.pichincha.pruebatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.pruebatec.entity.Movimiento;

@Repository
public interface MovimientoRespository extends JpaRepository<Movimiento, Long>{
	
}
