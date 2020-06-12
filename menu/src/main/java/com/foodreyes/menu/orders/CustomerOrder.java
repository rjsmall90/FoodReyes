package com.foodreyes.menu.orders;

import com.foodreyes.menu.core.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class CustomerOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "order_total")
    private BigDecimal orderTotal;

    @Column(name = "is_paid")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPaid;

    @Column(name = "is_shipped")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isShipped;
}
