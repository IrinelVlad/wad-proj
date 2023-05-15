package com.example.mvcproducts.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import java.util.Collection;
import java.util.HashMap;


@NoArgsConstructor
public class Cart {
    HashMap<Long, Pair<Product, Integer>> products = new HashMap<>();

    public Collection<Pair<Product, Integer>> getProducts() {
        return this.products.values();
    }
    public void addProduct(Long id, Product product) {
        if (!this.products.containsKey(id)) {
            this.products.put(id, Pair.of(product, 1));
        }
        else {
            this.products.put(id, Pair.of(product, this.products.get(id).getSecond()+1));
        }
    }

    public void increment(Long id) {
        this.products.put(id, Pair.of(this.products.get(id).getFirst(), this.products.get(id).getSecond()+1));
    }

    public void decrement(Long id) {
        if (this.products.get(id).getSecond() == 1) {
            this.products.remove(id);
        }
        else {
            this.products.put(id, Pair.of(this.products.get(id).getFirst(), this.products.get(id).getSecond()-1));
        }
    }

    public void clear() {
        this.products.clear();
    }
}
