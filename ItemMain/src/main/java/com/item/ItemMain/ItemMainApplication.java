package com.item.ItemMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.item.model")
@ComponentScan("com.item.controller")
@EnableJpaRepositories("com.item.repository")
@EnableEurekaClient
public class ItemMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemMainApplication.class, args);
	}

}
