package com.example.demo.service.categories;

import com.example.demo.model.Categories;

import java.util.List;
import java.util.Optional;

public interface ICategoriesService {
    // Create
    void addCategories(Categories categories);

    // Find
    List<Categories> findAllCategories();
    Optional<Categories> findCategoriesById(int categories_id);
    Optional<Categories> findCategoriesByName(String categories_name);
    List<Categories> searchCategories(String searchKeyword);

    // Update
    void updateCategories(Categories categories);

    // Delete
    boolean deleteCategoriesByName(String categories_name);
}
