package com.example.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//https://www.baeldung.com/spring-cloud-gateway

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.example.Gateway")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
