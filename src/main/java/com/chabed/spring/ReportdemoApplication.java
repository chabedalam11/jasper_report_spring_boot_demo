package com.chabed.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.chabed.spring.config"})
public class ReportdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReportdemoApplication.class, args);
		System.out.println("application start");
	}
}
