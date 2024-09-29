package card.cost.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot application
 * Implements RESTful service back-end
 *
 * Supports 1 API call
 *
 * 1. Bundle retrieve done by call CardCostController
 * (Method: POST Url: https://{host}/rest/v1/payment-cards-cost)
 * which responds CardInfoDTO in JSON format
 *
 */

@SpringBootApplication
public class CardCostApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardCostApiApplication.class, args);
    }

}
