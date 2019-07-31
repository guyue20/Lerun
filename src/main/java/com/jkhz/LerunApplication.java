package com.jkhz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.jkhz.mapper")
@SpringBootApplication
public class LerunApplication {
    public static void main(String[] args) {
        SpringApplication.run(LerunApplication.class, args);
    }

}
