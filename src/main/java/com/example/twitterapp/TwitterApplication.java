package com.example.twitterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class TwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders(
								"Access-Control-Allow-Headers",
								"Access-Control-Allow-Origin",
								"Access-Control-Request-Method",
								"Access-Control-Request-Headers",
								"Origin",
								"Cache-Control",
								"Content-Type",
								"Content-Length",
								"Host",
								"User-Agent",
								"Accept",
								"Accept-Encoding",
								"Connection",
								"Postman-Token",
								"Cookie",
								"Authorization",
								"clientId",
								"clientSecret",
								"External-Partner-Token")
						.allowCredentials(true)
						.exposedHeaders("Access-Control-Allow-Origin")
						.maxAge(3600);
			}
		};
	}

}
