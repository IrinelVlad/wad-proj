package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Career;
import com.example.mvcproducts.domain.Modification;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.repositories.ModificationRepository;
import com.example.mvcproducts.services.CareerService;
import com.example.mvcproducts.services.CareerServiceImpl;
import com.example.mvcproducts.services.ModificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Slf4j
public class CareerController {
    private final ModificationService modificationService;
    private final CareerService careerService;

    public CareerController(ModificationService modificationService,CareerService careerService) {
        this.modificationService = modificationService;
        this.careerService = careerService;
    }


    /*@GetMapping
    public String career() {
        return "career";
    }*/

    @GetMapping("/livery")
    public String livery() {
        return "livery";
    }



    @GetMapping("/driver")
    public String driver() {
        return "driver";
    }

    @PostMapping("/driver")
    public String driverMod(Authentication auth,@RequestBody Map<String, Object> data) {
        Modification driver = modificationService.findbyName((String) data.get("name"));
        User user = (User) auth.getPrincipal();
        careerService.findByUser(user).getModifications().add(driver);
        return "redirect:/engineer";
    }

    @GetMapping("/engine")
    public String engine() {

        return "engine";
    }

    @PostMapping("/engine")
    public String engineMod(Authentication authentication, @RequestBody Map<String, Object> data) {
        Modification engine = modificationService.findbyName((String) data.get("name"));
        User user = (User) authentication.getPrincipal();
        Career career = new Career(user);
        career.getModifications().add(engine);
        careerService.save(career);
        return "redirect:/livery";
    }

    @GetMapping("/engineer")
    public String engineer() {
        return "engineer";
    }
}
