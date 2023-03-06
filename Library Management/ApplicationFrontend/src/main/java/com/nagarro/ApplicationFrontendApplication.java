package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.nagarro")
public class ApplicationFrontendApplication extends SpringBootServletInitializer {
		
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationFrontendApplication.class);
	}
	
//	creating restTemplate for application that uses RESTful Web Services.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationFrontendApplication.class, args);
	}

}
