package com.shortmile.msgproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MsgProducerApplication {
	private static final Logger LOG = LoggerFactory.getLogger(MsgProducerApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MsgProducerApplication.class, args);

		Sender sender = context.getBean(Sender.class);
		for (int i = 0; i < 10; i++) {
			sender.send(String.format("Message %d", i));
			try {
				Thread.sleep(1000 * 4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOG.info("Finished sending!!!");
	}

}
