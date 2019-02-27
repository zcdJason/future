package com.future.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zcd
 */
@SpringBootApplication
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
