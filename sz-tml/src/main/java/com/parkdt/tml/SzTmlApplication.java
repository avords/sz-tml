package com.parkdt.tml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.parkdt.tml.mapper")
@SpringBootApplication
public class SzTmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzTmlApplication.class, args);
	}

}
