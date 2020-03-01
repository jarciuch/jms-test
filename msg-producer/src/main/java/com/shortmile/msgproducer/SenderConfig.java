package com.shortmile.msgproducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class SenderConfig {

  @Value("${activemq.broker-url}")
  private String brokerUrl;

  @Bean
  public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
    ActiveMQConnectionFactory activeMQConnectionFactory =
        new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL(brokerUrl);

    return activeMQConnectionFactory;
  }

  @Bean
  public CachingConnectionFactory cachingConnectionFactory() {
    return new CachingConnectionFactory(
        senderActiveMQConnectionFactory());
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    return new JmsTemplate(cachingConnectionFactory());
  }

  @Bean
  public Sender sender() {
    return new Sender();
  }

  @Bean
  CommandLineRunner runner(final ApplicationContext context) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
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
        //LOG.info("Finished sending!!!");
      }
    };
  }
}
