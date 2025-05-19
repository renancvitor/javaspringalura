package com.renan.javaspring.apiTabelaFipe;

import com.renan.javaspring.JavaspringApplication;
import com.renan.javaspring.apiTabelaFipe.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main principal = new Main();
        principal.exibeMenuFipe();
    }
}
