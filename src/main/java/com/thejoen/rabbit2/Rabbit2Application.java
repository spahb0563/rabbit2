package com.thejoen.rabbit2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class Rabbit2Application {
	public static void main(String[] args) {
		SpringApplication.run(Rabbit2Application.class, args);
	}
}
