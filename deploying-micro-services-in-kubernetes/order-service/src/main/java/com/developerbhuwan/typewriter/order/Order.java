package com.developerbhuwan.typewriter.order;

import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.developerbhuwan.typewriter.order.OrderLine.ItemId;
import static com.developerbhuwan.typewriter.order.OrderLine.ItemQuantity;

@Entity
@Table(name = Order.TABLE_PREFIX + "Order")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
@ToString(exclude = {"orderLines", "address"})
public class Order extends AbstractAggregateRoot<Order> implements Serializable {

    public static final String SCHEMA = "order_management";
    public static final String TABLE_PREFIX = "Typewriter";
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    private String refNo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
    private LocalDateTime orderAt;
    private Address address;

    private Order(String refNo, List<OrderLine> orderLines) {
        this.orderAt = LocalDateTime.now();
        this.refNo = refNo;
        this.orderLines = orderLines;
    }

    static OrderBuilder of(ItemId itemId, ItemQuantity quantity) {
        return new OrderBuilder().add(new OrderLine(itemId, quantity));
    }


    @Value
    @Embeddable
    static class Address {
        private final String description;
    }

    public static class OrderBuilder {
        private final String refNo;
        private List<OrderLine> orderLines = new LinkedList<>();

        OrderBuilder() {
            this.refNo = UUID.randomUUID().toString();
        }

        OrderBuilder add(OrderLine orderLine) {
            orderLines.add(orderLine);
            return this;
        }

        Order create() {
            Order order = new Order(refNo, orderLines);
            order.registerEvent(new OrderAdded(refNo, orderLines));
            return order;
        }
    }


}
