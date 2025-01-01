package com.gitbasic.gitbasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GitbasicApplication {
	private static final Logger log = LoggerFactory.getLogger(GitbasicApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GitbasicApplication.class, args);
	}
}
