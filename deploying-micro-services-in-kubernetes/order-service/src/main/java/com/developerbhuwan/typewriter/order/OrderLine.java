package com.developerbhuwan.typewriter.order;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import static com.developerbhuwan.typewriter.order.Order.TABLE_PREFIX;

@Entity
@Table(name = TABLE_PREFIX + "OrderLine")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
public class OrderLine implements Serializable {
    private ItemId itemId;
    private ItemQuantity quantity;
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    OrderLine(ItemId itemId, ItemQuantity quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    @Value
    @Embeddable
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @RequiredArgsConstructor
    static class ItemId {
        private String itemNo;
    }

    @Value
    @Embeddable
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @RequiredArgsConstructor
    static class ItemQuantity {
        private final Integer quantity;
    }

}