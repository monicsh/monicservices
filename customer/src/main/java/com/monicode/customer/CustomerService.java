package com.monicode.customer;

import com.monicode.amqp.RabbitMQMessageProducer;
import com.monicode.clients.fraud.FraudCheckResponse;
import com.monicode.clients.fraud.FraudClient;
//import com.monicode.clients.notification.NotificationClient;
import com.monicode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
//    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO : check email is valid
        // TODO : check email is not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
//
//        // Send notification asynchronously
        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(),
                        customer.getEmail());

//        String.format("Hi %s, welcome to monicode...", customer.getFirstName())
//        notificationClient.sendNotification(notificationRequest);
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"

        );


    }
}
