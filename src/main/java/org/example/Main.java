package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.service.PizzaService;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("A", 25, true);
        Pizza pizza2 = new Pizza("B", 29, true);
        Pizza pizza3 = new Pizza("C", 45, false);
        Pizza pizza4 = new Pizza("D", 14, false);

        PizzaService pizzaService = new PizzaService(List.of(pizza1, pizza2, pizza3, pizza4));
        logger.info(pizzaService.getAvailablePizzas());

        Order order1 = pizzaService.makeOrder(List.of(pizza1));
        logger.info(order1);

        Order order2 = pizzaService.makeOrder(List.of(pizza1, pizza2));
        logger.info(order2);

        try {
            Order order3 = pizzaService.makeOrder(List.of(pizza3, pizza4));
        } catch (Exception ex) {
            logger.error("Taka pizza nie istnieje", ex);
        }
    }
}