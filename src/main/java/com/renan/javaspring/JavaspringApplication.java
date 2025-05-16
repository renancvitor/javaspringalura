package com.renan.javaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		System.out.println("Primeiro projeto Spring sem Web");
	}
}
