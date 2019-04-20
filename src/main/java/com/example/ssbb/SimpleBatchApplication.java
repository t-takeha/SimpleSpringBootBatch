package com.example.ssbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {
		"com.example.ssbb.common.configuration",
		"com.example.ssbb.common.listener",
		"com.example.ssbb.common.tasklet",
		"com.example.ssbb.configuration",
		"com.example.ssbb.mapper",
		"com.example.ssbb.tasklet"})
public class SimpleBatchApplication {

	public static void main(String[] args) {
		System.out.println("### START SimpleBatchApplication");
		SpringApplication.run(SimpleBatchApplication.class, args);
	}
}
