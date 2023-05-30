package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Career;
import com.example.mvcproducts.domain.User;

public interface CareerService {
    Career findByUser(User user);
    void save(Career career);
}
