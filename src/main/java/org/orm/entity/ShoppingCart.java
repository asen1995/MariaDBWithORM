package org.orm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "max_weight_kg")
    private Integer maxWeightKg;

    @OneToOne(mappedBy = "shoppingCart")
    private Client client;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Product> products;



}
