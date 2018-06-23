package com.developerbhuwan.typewriter.payment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = OrderPayment.PREFIX + "OrderPayment", schema = "payment-management")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
class OrderPayment extends AbstractAggregateRoot<OrderPayment> implements Serializable {

    public static final String PREFIX = "Typewriter";
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    private OrderId orderId;
    private PaidAmount amount;
    private LocalDateTime paidAt;

    @Value
    @Embeddable
    private static class OrderId {
        private String refNo;
    }

    @Value
    @Embeddable
    private static class PaidAmount {
        private BigDecimal amount;
    }


}
