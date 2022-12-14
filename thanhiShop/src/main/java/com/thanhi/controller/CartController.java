package com.thanhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping("view")
    public String view(Model model) {
        model.addAttribute("activeMenu","view");
        return "cart/view";
    }
}
