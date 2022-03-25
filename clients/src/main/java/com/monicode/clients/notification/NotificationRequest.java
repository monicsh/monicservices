package com.monicode.clients.notification;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest{
    private Integer customerId;
    private String email;
}
