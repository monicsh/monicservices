package com.monicode.notification.rabbitmq;

import com.monicode.clients.notification.NotificationRequest;
import com.monicode.notification.Notification;
import com.monicode.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues="${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumed {} from Queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
