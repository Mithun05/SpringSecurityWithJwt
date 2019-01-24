package com.room.accesser.jwt.examples;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class JavaRoomAccesserApplication {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(JavaRoomAccesserApplication.class);


	public static void main(String[] args) {
		logger.debug("Welcome To Java Room Accesser Spring Boot Application");
		SpringApplication.run(JavaRoomAccesserApplication.class, args);
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

