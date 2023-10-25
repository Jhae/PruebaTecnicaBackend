package com.pichincha.pruebatec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pichincha.pruebatec.response.converter.ReporteMovimientoConverter;


@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ReporteMovimientoConverter.ToReporteMovimientoDto());
    }
	
}
