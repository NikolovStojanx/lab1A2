package com.example.lab1a2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab1A2Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1A2Application.class, args);
    }

}
