package com.example.mineappclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MineAppClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineAppClientApplication.class, args);
	}

}
