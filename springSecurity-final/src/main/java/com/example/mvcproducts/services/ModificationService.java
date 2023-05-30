package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Modification;

public interface ModificationService {
    Modification findbyName(String name);
    void save (Modification modification);
}
