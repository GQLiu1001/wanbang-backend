package com.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com.wanbang.mapper")
@SpringBootApplication
@EnableTransactionManagement  // 添加这一行 事务原子性
public class WanbangBackendApplication {
	//TODO 增加redis数据缓存
	public static void main(String[] args) {
		SpringApplication.run(WanbangBackendApplication.class, args);
	}


}
