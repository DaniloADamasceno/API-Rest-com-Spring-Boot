package com.modulo24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SuppressWarnings("ALL")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApiRestfulSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulSpringBootApplication.class, args);
	}

}
