package com.mysycorp.Backendjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.ailef.snapadmin.external.SnapAdminAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(SnapAdminAutoConfiguration.class)
public class BackendjoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendjoApplication.class, args);
		System.out.println("hello,world");
	}

}
