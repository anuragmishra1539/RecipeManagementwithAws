package com.geekster.moduleclearancetest.RecipeManagementSystemAPI.repository;

import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String newEmail);
}

