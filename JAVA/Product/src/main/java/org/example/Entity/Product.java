package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private float price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ProductFood")
    private Produit_Food produitFood;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ProductElectronic")
    private Product_Electronic product_electronic;

}
