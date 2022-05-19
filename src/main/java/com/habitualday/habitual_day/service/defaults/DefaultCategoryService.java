package com.habitualday.habitual_day.service.defaults;

import com.habitualday.habitual_day.entity.Category;
import com.habitualday.habitual_day.repository.CategoryRepository;
import com.habitualday.habitual_day.service.intefaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return Optional.empty();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategoryById(Long id) {

    }

    @Override
    public void editCategory(Category Category) {

    }
}
