package org.aisa.controller;

import lombok.extern.slf4j.Slf4j;
import org.aisa.entity.Coffee;
import org.aisa.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/coffee")
@Slf4j
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("")
    public List<Coffee> getCoffee() {
        log.info("process=get-coffee");
        return coffeeService.getAllCoffee();
    }
}
