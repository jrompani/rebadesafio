package com.reba.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.reba.application.repository")
public class RebaDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebaDesafioApplication.class, args);
	}

}
