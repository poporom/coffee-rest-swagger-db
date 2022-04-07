package org.aisa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer cost;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "coffee_ingredients", joinColumns = @JoinColumn(name = "coffee_id"))
    @MapKeyColumn(name="ingredient_id")
    @Column(name = "quantity")
    private Map<String, Integer> ingredients = new HashMap<>();

}