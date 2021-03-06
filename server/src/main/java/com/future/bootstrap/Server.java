package com.future.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zcd
 */
@SpringBootApplication
@Configuration
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

//    @Configuration
//    @ComponentScan({"com.zdww.demo.web.controller.test"})
//    public class codeGenDemoScan {
//    }
}
