package com.shortmile.msgproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsgProducerApplication {
	private static final Logger LOG = LoggerFactory.getLogger(MsgProducerApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MsgProducerApplication.class, args);
	}
}
