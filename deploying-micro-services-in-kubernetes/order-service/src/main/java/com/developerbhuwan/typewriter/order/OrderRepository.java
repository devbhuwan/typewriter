package com.developerbhuwan.typewriter.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

import static com.developerbhuwan.typewriter.order.Order.Address;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    List<Order> findAllByAddress(@RequestBody Address address);

    List<Order> findAllByOrderAt(@Param("orderAt") LocalDateTime orderAt);
}
