package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@MapperScan("com.java.mapper")
@RestController
@SpringBootApplication
public class SpringbootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}


	@GetMapping(value="hello")
	public String hello(){
		return "123";
	}
}
