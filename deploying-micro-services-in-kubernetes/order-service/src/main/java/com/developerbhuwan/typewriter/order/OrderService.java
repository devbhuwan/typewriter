package com.developerbhuwan.typewriter.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.developerbhuwan.typewriter.order.OrderLine.ItemId;
import static com.developerbhuwan.typewriter.order.OrderLine.ItemQuantity;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository repository;

    void addNewOrder(ItemId itemId, ItemQuantity quantity) {
        Order order = repository.save(Order.of(itemId, quantity).create());
        LOG.info("New order arrived: {}", order);
    }

}
