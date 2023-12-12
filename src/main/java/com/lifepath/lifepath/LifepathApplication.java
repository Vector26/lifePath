package com.lifepath.lifepath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lifepath")
public class LifepathApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifepathApplication.class, args);
	}

}
