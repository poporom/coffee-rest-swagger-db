package org.aisa.controller;

import lombok.extern.slf4j.Slf4j;
import org.aisa.service.CoffeeService;
import org.aisa.service.IngredientService;
import org.aisa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public Long getMoney() {
        log.info("process=get-ingredients");
        return orderService.getMoney();
    }

    @GetMapping("/{index}")
    public void buyCoffee(@PathVariable Integer index) {
        log.info("process=update-ingredient");
        orderService.buyCoffee(index);
    }

    @DeleteMapping("")
    public void takeMoney() {
        log.info("process=delete-money");
        orderService.deleteMoney();
    }

}
