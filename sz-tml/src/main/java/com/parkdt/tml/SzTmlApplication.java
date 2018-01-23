package com.parkdt.tml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//重点
@ServletComponentScan
public class SzTmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzTmlApplication.class, args);
	}
	
}
