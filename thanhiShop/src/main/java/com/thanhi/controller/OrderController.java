package com.thanhi.controller;

import com.thanhi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @GetMapping("/list")
    public String list() {
        return "order/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }

    @GetMapping("/checkout")
    public String checkout() {
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(au.getName());
        return "order/checkout";
    }
}
