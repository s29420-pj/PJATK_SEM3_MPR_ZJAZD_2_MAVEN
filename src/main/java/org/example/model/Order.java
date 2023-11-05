package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter     //
@Setter     // @Data zawiera wszystkie trzy adnotacje, czyli @Getter, @Setter, @ToString
@ToString   //
public class Order {
    private int number;
    private List<Pizza> orderedPizzas;
    private double price;
}
