package com.njProjectServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.njProjectServer")
@SpringBootApplication
public class NjProjectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjProjectServerApplication.class, args);
	}

}
