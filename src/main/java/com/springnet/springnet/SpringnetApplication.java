package com.springnet.springnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringnetApplication.class, args);
		System.out.println("SpringNet works! SUWI");
	}

}
