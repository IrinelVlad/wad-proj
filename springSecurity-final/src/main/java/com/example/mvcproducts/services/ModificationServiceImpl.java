package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Modification;
import com.example.mvcproducts.repositories.ModificationRepository;
import org.springframework.stereotype.Service;

@Service
public class ModificationServiceImpl implements ModificationService {
    private final ModificationRepository modificationRepository;

    public ModificationServiceImpl(ModificationRepository modificationRepository) {
        this.modificationRepository = modificationRepository;
    }

    @Override
    public Modification findbyName(String name) {
        return modificationRepository.findByName(name);
    }

    @Override
    public void save(Modification modification) {
        modificationRepository.save(modification);
    }
}
