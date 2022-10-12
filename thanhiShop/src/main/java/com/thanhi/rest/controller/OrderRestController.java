package com.thanhi.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhi.model.Account;
import com.thanhi.model.Order;
import com.thanhi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class OrderRestController {
    @Autowired
    IOrderService orderService;

    @PostMapping("/rest/orders")
    public Order create(@RequestBody JsonNode oderData) {
        System.out.println("rest order");
        return orderService.create(oderData);
    }
    @PostMapping("/rest/test")
    public Account test() throws JsonProcessingException {
        Account a = new Account();
        a.setUsername("thanh");
        return a;
    }
}
