package com.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.wanbang.mapper")
@SpringBootApplication
public class WanbangBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WanbangBackendApplication.class, args);
	}

}
