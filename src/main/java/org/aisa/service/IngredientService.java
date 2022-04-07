package org.aisa.service;

import org.aisa.entity.Ingredient;
import org.aisa.model.IngredientRequest;
import org.aisa.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public void updateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void reduceIngredient(String ingredientName, Integer count) {
        Ingredient ingredient = ingredientRepository.findById(ingredientName).get();
        int newQuantity = ingredient.getQuantity() - count;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough ingredients");
        }
        ingredient.setQuantity(newQuantity);
        ingredientRepository.save(ingredient);
    }
}
