package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
// @Getter odnosi się do całej klasy
// @Setter odnosi się do całej klasy
public class Pizza {
    // @Getter odnosi się tylko do name
    // @Setter odnosi się tylko do name
    private String name;
    private double price;
    private boolean isAvailable;
}
