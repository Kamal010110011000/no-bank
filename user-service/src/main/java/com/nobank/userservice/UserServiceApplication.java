package com.nobank.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableCircuitBreaker
@EnableZuulProxy
//@EnableDiscoveryClient
//@EnableEurekaClient
public class UserServiceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
		
	}

}
