package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] argumentos) {
        System.out.println("Iniciando API Gateway...");
        SpringApplication.run(App.class, argumentos);
    }
}
