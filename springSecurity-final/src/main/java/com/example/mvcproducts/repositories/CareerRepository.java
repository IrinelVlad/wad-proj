package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.Career;
import com.example.mvcproducts.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CareerRepository extends CrudRepository<Career, Long> {
    Career findByUser(User user);
}
