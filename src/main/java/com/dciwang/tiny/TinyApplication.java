package com.dciwang.tiny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class TinyApplication {

    public static void main(String[] args) throws MalformedURLException {
        SpringApplication.run(TinyApplication.class, args);
        System.out.println("启动成功, Swagger访问:"+new URL("http://localhost:8080/swagger-ui.html"));
    }

}
