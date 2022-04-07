package org.aisa.controller;

import lombok.extern.slf4j.Slf4j;
import org.aisa.entity.Ingredient;
import org.aisa.model.IngredientRequest;
import org.aisa.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@Slf4j
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("")
    public List<Ingredient> getIngredients() {
        log.info("process=get-ingredients");
        return ingredientService.getIngredients();
    }

    @PutMapping("")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        log.info("process=update-ingredient");
        ingredientService.updateIngredient(ingredient);
    }

}
