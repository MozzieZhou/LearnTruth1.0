package com.gem.learntruth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gem.learntruth.mapper")
public class LearntruthApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearntruthApplication.class, args);
	}
}
