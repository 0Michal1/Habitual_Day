package com.habitualday.habitual_day.repository;


import com.habitualday.habitual_day.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
