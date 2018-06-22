package com.developerbhuwan.typewriter.order;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.io.Serializable;

import static com.developerbhuwan.typewriter.order.Order.TABLE_PREFIX;

@Entity
@Table(name = TABLE_PREFIX + "OrderLine")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class OrderLine implements Serializable {
    @Id
    private Long id;
    @Version
    private Long version;
    private ItemId itemId;
    private ItemQuantity quantity;


    @Value
    @Embeddable
    public static class ItemId {
        private String itemNo;
    }

    @Value
    @Embeddable
    public static class ItemQuantity {
        private final Integer quantity;
    }

}