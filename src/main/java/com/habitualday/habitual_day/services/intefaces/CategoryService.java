package com.habitualday.habitual_day.services.intefaces;


import com.habitualday.habitual_day.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(Long id);
    Optional<Category> findCategoryByName(String name);
    void createCategory(Category category);
    void deleteCategoryById(Long id);
    void editCategory(Category Category);
}
