package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home(Authentication authentication) {
    if (authentication == null)
      return "home";
    return "redirect:/engine";
  }

  @PostMapping("/logout")
  public String logout() {
    return "home";
  }

  @GetMapping("/login")
  public String showLogin() {
    return "login";
  }
  @PostMapping("/login")
  public String login() {
    return "redirect:/engine";
  }


}
