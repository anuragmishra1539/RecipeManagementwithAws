package com.geekster.moduleclearancetest.RecipeManagementSystemAPI.repository;

import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.Recipe;
import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByOwnerAndId(User owner, Long id);
}

