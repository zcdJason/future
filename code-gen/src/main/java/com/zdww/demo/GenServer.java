package com.zdww.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcd
 */
@SpringBootApplication
@Configuration
@MapperScan("com.zdww.demo.dao.mapper.test")
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
