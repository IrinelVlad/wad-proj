package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.domain.Role;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Your other controller methods
    @GetMapping
    public String showAddProductForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping
    public String registerUser(User user) {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        // Save the user in the database using the UserRepository
        User user1 = new User(user.getUsername(),bcrypt.encode(user.getPassword()),user.getEmail());
        user1.getRoles().add(Role.ROLE_USER);
        userRepository.save(user1);

        // Redirect to a success page or perform any other necessary actions
        return "redirect:/login";
    }
}
