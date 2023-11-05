package org.example.service;

import org.example.exception.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {
    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;
    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
    public Order makeOrder(List<Pizza> orderedPizzas) {
        // oczekujemy tutaj zwrócenia informacji o zamówieniu
        // (nr zamówienia, pizza, cena)


        // Sprawdzamy czy zamówione pizze są dostępne
        // Tworzymy obiekt Order
        // Numer zamówienia będzie bazował na rozmiarze orderList
        // Cena to suma cen wszystkich zamówionych pizz
        // Dodajemy order do OrderList
        // Zwracamy order

        if (getAvailablePizzas().containsAll(orderedPizzas)) {
            double sum = orderedPizzas.stream()
                    .map(Pizza::getPrice)
                    .reduce(0D, (current, price) -> current + price);

            Order order = new Order(orderList.size(), orderedPizzas, sum);

            orderList.add(order);

            return order;
        } else {
            throw new PizzaNotFoundException();
        }
    }

    public List<Pizza> getAvailablePizzas(){
        // Zwrócenie listy dostępnych pizz;
        return pizzaList.stream()
                .filter(Pizza::isAvailable)
                .collect(Collectors.toList());
    }

}
