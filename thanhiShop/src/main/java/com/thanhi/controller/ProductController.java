package com.thanhi.controller;

import com.thanhi.model.Product;
import com.thanhi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("home")
    public String home(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        model.addAttribute("activeMenu","home");
        return "product/home";
    }

    @GetMapping("list")
    public String list(Model model, @RequestParam(value = "cid") Optional<Integer> cid) {
        List<Product> list;
        if (cid.isPresent()) {
            list = productService.findByCategoryId(cid.get());
        } else {
            list = productService.findAll();
        }
        model.addAttribute("items", list);
        model.addAttribute("activeMenu","shop");
        return "product/list-follow-category";
    }
    @GetMapping("detail")
    public String detial(Model model, @RequestParam(value = "id")Long id) {
        Product p = productService.findById(id);
        List<Product> list = productService.findAll();
        model.addAttribute("productList", list);
        model.addAttribute("product", p);
        return "product/detail";
    }
}
