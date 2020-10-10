package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


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
