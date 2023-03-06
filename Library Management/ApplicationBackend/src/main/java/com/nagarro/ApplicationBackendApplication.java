package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.nagarro" })
public class ApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBackendApplication.class, args);
	}

}
