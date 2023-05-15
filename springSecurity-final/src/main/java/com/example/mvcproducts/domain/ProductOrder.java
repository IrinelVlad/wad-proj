package com.example.mvcproducts.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class ProductOrder {
  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  private User user;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<OrderLineItem> orderLineItems = new HashSet<>();


  public ProductOrder(User user) {
    this.user = user;
  }

  public void addProduct(Product product, int qty) {
    orderLineItems.add(new OrderLineItem(product, qty));
  }
}
