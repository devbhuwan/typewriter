package com.developerbhuwan.typewriter.payment;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order-payments", collectionResourceRel = "order-payments")
public interface OrderPaymentRepository extends PagingAndSortingRepository<OrderPayment, Long> {

}
