package com.example.mvcproducts.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Modification {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Type type;
    private int skill;

    public Modification(String name, Type type, int skill) {
        this.name = name;
        this.type = type;
        this.skill = skill;
    }


}
