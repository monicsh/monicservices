package com.monicode.notification;

import com.monicode.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication(
        scanBasePackages = {
                "com.monicode.notification",
                "com.monicode.amqp",
        }
)
//@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//                                        NotificationConfig notificationConfig){
//        return args -> {
//            producer.publish("foo",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//
//        };
//    }
}
