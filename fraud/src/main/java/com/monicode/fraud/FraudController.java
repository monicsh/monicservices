package com.monicode.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerID}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerID") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        log.info("fraud check for customer : {}", customerID);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
