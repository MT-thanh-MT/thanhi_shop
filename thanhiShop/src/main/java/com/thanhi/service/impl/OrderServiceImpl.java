package com.thanhi.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhi.model.Order;
import com.thanhi.model.OrderDetail;
import com.thanhi.repository.OrderDetailRepository;
import com.thanhi.repository.OrderRepository;
import com.thanhi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode oderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(oderData, Order.class);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> details = mapper.convertValue(oderData.get("orderDetails"), type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);

        return order;
    }

    @Override
    public Object findById(Long id) {
        return orderRepository.findById(id).get();
    }
}
