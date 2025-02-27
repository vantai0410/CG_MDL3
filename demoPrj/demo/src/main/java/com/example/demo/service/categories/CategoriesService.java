package com.example.demo.service.categories;

import com.example.demo.model.Categories;
import com.example.demo.repository.categories.CategoriesRepository;
import com.example.demo.repository.categories.ICategoriesRepository;

import java.util.List;
import java.util.Optional;

public class CategoriesService implements ICategoriesService {
    private final ICategoriesRepository categoriesRepo = new CategoriesRepository();

    public CategoriesService() {
    }

    // CREAT
    @Override
    public void addCategories(Categories categories) {
        categoriesRepo.addCategories(categories);
    }

    // FIND
    @Override
    public List<Categories> findAllCategories() {
        return categoriesRepo.findAllCategories();
    }

    @Override
    public Optional<Categories> findCategoriesById(int categories_id) {
        return categoriesRepo.findCategoriesById(categories_id);
    }

    @Override
    public Optional<Categories> findCategoriesByName(String categories_name) {
        return categoriesRepo.findCategoriesByName(categories_name);
    }

    @Override
    public List<Categories> searchCategories(String searchKeyword) {
        return categoriesRepo.searchCategories(searchKeyword);
    }

    // UPDATE
    @Override
    public void updateCategories(Categories categories) {
        categoriesRepo.updateCategories(categories);
    }

    // DELETE
    @Override
    public boolean deleteCategoriesByName(String categories_name) {
        return categoriesRepo.deleteCategoriesByName(categories_name);
    }
}
