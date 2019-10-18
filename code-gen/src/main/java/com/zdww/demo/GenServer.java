package com.zdww.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcd
 */
@SpringBootApplication
@Configuration
public class GenServer
{
    public static void main(String[] args) {
        SpringApplication.run(GenServer.class, args);
    }

//    @Configuration
//    @ComponentScan({"com.zdww.demo.web.controller.test"})
//    public class codeGenDemoScan {
//    }
}
