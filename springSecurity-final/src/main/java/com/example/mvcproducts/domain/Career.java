package com.example.mvcproducts.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Career {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany // maybe @ElementCollection(fetch = FetchType.EAGER)
    private List<Modification> modifications = new ArrayList<>();
    @OneToOne
    private User user;

    public Career(User user) {
        this.user = user;
    }
}
