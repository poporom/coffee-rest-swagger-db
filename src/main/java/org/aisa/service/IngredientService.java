package org.aisa.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aisa.entity.Ingredient;
import org.aisa.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class IngredientService {
    IngredientRepository ingredientRepository;

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
