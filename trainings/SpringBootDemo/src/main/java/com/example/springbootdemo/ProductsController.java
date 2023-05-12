package com.example.springbootdemo;

import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String viewProducts(Model model){
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
