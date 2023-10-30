package com.geekster.moduleclearancetest.RecipeManagementSystemAPI.repository;


import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.AuthenticationToken;
import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}