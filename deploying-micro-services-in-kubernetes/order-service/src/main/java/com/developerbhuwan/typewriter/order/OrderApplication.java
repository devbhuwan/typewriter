package com.developerbhuwan.typewriter.order;

import com.developerbhuwan.typewriter.order.OrderLine.ItemId;
import com.developerbhuwan.typewriter.order.OrderLine.ItemQuantity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

import static java.util.UUID.randomUUID;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class OrderApplication {

    private final OrderService service;
    private final Random random = new Random(1);

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Scheduled(cron = "0 0/1 * 1/1 * ? *")
    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        LOG.info("------------ Create New Order --------------------");
        service.addNewOrder(new ItemId(randomUUID().toString()), new ItemQuantity(Math.abs(random.nextInt(50))));
        LOG.info("------------     Finished     --------------------");
    }


    @EventListener
    public void onOrderAdded(OrderAdded orderAdded) {
        LOG.info("Received an order : {}", orderAdded);

    }

}
