package com.wlorente.omni.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wlorente.omni.usercases.DBServiceUseCase;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServiceUseCase dBServiceUseCase; 
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dBServiceUseCase.instantiateTestDatabase();
		return true;
	}
}
