package com.developerbhuwan.typewriter.order;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@RequiredArgsConstructor
@Value
class OrderAdded {
    private final String orderRef;
    private final List<OrderLine> orderLines;

}
