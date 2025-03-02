package com.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.wanbang.mapper")
@SpringBootApplication
@EnableTransactionManagement  // 添加这一行
public class WanbangBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WanbangBackendApplication.class, args);
	}

}
