package com.mall.learnMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class LearnMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMallApplication.class, args);
	}

}
