package org.aisa.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aisa.entity.Coffee;
import org.aisa.repo.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class CoffeeService {
    CoffeeRepository coffeeRepository;

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffee(Integer id) {
        return coffeeRepository.findById(id).get();
    }
}
