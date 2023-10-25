package com.pichincha.pruebatec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pichincha.pruebatec.repository.CustomMovimientoRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class PruebaTecnicaApplication {

	private final CustomMovimientoRepository movimientoRespository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run() {
		return (String[] as)->{
			movimientoRespository.reporteMovimientos("20/10/2023", "25/10/2023");
		};
	}

}
