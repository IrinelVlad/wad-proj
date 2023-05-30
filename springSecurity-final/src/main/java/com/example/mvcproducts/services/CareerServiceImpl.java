package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Career;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.repositories.CareerRepository;
import org.springframework.stereotype.Service;

@Service
public class CareerServiceImpl implements CareerService{
    private final CareerRepository careerRepository;

    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public Career findByUser(User user) {
        return careerRepository.findByUser(user);
    }

    @Override
    public void save(Career career) {
        careerRepository.save(career);
    }
}
