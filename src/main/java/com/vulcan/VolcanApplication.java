package com.vulcan;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

=======
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vulcan.*.mapper")
>>>>>>> d24df4fb3a6d7cd7597a4f208ddaa50d27f44eda
@SpringBootApplication
public class VolcanApplication {
    public static void main(String[] args) {
        SpringApplication.run(VolcanApplication.class,args);
    }
}
