package org.aisa.service;

import org.aisa.entity.Coffee;
import org.aisa.repo.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffee(Integer id) {
        return coffeeRepository.findById(id).get();
    }
}
