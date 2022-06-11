package com.acme.mylawyerbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MyLawyerBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLawyerBeApplication.class, args);
    }

}
