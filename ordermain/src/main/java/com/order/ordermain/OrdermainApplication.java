package com.order.ordermain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.order.model")
@ComponentScan("com.order.controller")
@EnableJpaRepositories("com.order.repository")
@EnableEurekaClient
public class OrdermainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermainApplication.class, args);
	}

}
