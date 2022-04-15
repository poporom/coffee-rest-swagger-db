package org.aisa.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aisa.entity.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class OrderService {
    private final CoffeeService coffeeService;
    private final IngredientService ingredientService;
    private static Long money = 0L;

    @Autowired
    public OrderService(CoffeeService coffeeService, IngredientService ingredientService) {
        this.coffeeService = coffeeService;
        this.ingredientService = ingredientService;
    }

    public Long getMoney() {
        return money;
    }

    public void deleteMoney() {
        money = 0L;
    }

    public void buyCoffee(Integer index) {
        Coffee coffee = coffeeService.getCoffee(index);
        for (Map.Entry<String, Integer> entry : coffee.getIngredients().entrySet()) {
            ingredientService.reduceIngredient(entry.getKey(), entry.getValue());
        }
        money += coffee.getCost();
    }
}
