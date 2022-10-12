package com.thanhi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.thanhi.model.Order;

public interface IOrderService {
    Order create(JsonNode oderData);

    Object findById(Long id);
}
