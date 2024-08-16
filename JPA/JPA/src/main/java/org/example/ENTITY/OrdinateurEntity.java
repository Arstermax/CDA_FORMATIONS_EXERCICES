package org.example.ENTITY;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdinateurEntity {
    @Id @GeneratedValue()
    private int id;
    private String name;
    private String dexcriptions;
    private int price;
}
