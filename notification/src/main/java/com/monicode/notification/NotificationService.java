package com.monicode.notification;

import com.monicode.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder().
                        customerId(notificationRequest.getCustomerId()).
                        email(notificationRequest.getEmail()).
                        notificationDateTime(LocalDateTime.now()).
                        message("Notified that customer is registered!!").
                        build()
        );
    }
}
