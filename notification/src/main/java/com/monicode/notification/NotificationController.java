package com.monicode.notification;

import com.monicode.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Notification Request made by customer_id : " + notificationRequest.getCustomerId());

    }
}
