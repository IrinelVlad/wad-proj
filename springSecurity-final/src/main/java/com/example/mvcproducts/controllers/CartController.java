package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.domain.ProductOrder;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.OrderService;
import com.example.mvcproducts.services.ProductService;
import com.example.mvcproducts.services.UserService;
import com.example.mvcproducts.services.UserServiceImpl;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    ProductService productService;
    OrderService orderService;
    UserService userService;

    public CartController(ProductService productService, OrderService orderService, UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String seeCart(Model model, @ModelAttribute Cart cart) {
        model.addAttribute("items", cart.getProducts());
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam Long pid, @ModelAttribute("cart") Cart cart) {
        cart.addProduct(pid, productService.findProductById(pid));
        return "redirect:/products";
    }

    @GetMapping("/cart/increment")
    public String incrementItem(@RequestParam Long pid, @ModelAttribute("cart") Cart cart) {
        cart.increment(pid);
        return "redirect:/cart";
    }

    @GetMapping("/cart/decrement")
    public String decrementItem(@RequestParam Long pid, @ModelAttribute("cart") Cart cart) {
        cart.decrement(pid);
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(@ModelAttribute Cart cart, Authentication authentication) {
        ProductOrder productOrder = new ProductOrder((User) authentication.getPrincipal());
        for (Pair<Product, Integer> item : cart.getProducts()) {
            productOrder.addProduct(item.getFirst(), item.getSecond());
        }
        cart.clear();
        orderService.save(productOrder);
        return "redirect:/products";
    }
}
