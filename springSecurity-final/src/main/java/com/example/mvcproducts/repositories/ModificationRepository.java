package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.Modification;
import org.springframework.data.repository.CrudRepository;

public interface ModificationRepository extends CrudRepository<Modification, Long> {
    Modification findByName(String name);
}
