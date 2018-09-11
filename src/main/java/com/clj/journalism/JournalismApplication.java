package com.clj.journalism;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.clj.journalism.mapper")
public class JournalismApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalismApplication.class, args);
    }
}
