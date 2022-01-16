package com.drrotstein.rotsteinfileserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.drrotstein.rotsteinfileserver.storage.IStorageService;
import com.drrotstein.rotsteinfileserver.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@ImportResource("com/drrotstein/rotsteinfileserver/config/beans.xml")
public class RotsteinFileserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RotsteinFileserverApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(IStorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}