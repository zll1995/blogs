package com.jk;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.jk.*.mapper")
@EnableScheduling   //定时器注解
public class SpringbootBlogsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogsProviderApplication.class, args);
    }

}
