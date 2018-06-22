package com.developerbhuwan.typewriter.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = Order.TABLE_PREFIX + "Order")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
public class Order extends AbstractAggregateRoot<Order> implements Serializable {

    public static final String SCHEMA = "order_management";
    public static final String TABLE_PREFIX = "Typewriter";
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
    private LocalDateTime orderAt;
    private Address address;

    @Value
    @Embeddable
    public static class Address {
        private final String description;
    }
}
