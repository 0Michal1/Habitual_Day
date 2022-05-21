package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.controllers.createHabit.CreateHabitModel;
import com.habitualday.habitual_day.entities.Category;
import com.habitualday.habitual_day.entities.Habit;
import com.habitualday.habitual_day.repositories.CategoryRepository;
import com.habitualday.habitual_day.repositories.HabitRepository;
import com.habitualday.habitual_day.services.intefaces.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DefaultHabitService implements HabitService {
    private final HabitRepository habitRepository;
    private  final CategoryRepository categoryRepository;

    @Override
    public List<Habit> findAllHabits() {
        return habitRepository.findAll();
    }

    @Override
    public Optional<Habit> findHabitById(Long id) {
        return habitRepository.findById(id);
    }

    @Override
    public Optional<Habit> findHabitByName(String name) {
        return habitRepository.findByName(name);
    }

    @Override
    public void createHabit(CreateHabitModel createHabitModel) {
        List <Category> categories;
        if(createHabitModel.getCategories()!=null){
            categories =createHabitModel.getCategories();
        }else {
            categories = new ArrayList<>();
        }

        if (createHabitModel.getCategoryName()!= null){
            Category category = categoryRepository.findByName(createHabitModel.getCategoryName())
                    .orElseGet(()->categoryRepository.save(Category.builder()
                            .name(createHabitModel.getCategoryName())
                            .build()));
            categories.add(category);
        }
        habitRepository.save(Habit.builder()
                .name(createHabitModel.getName())
                        .categories(categories)
                        .type(createHabitModel.getType())
                        .description(createHabitModel.getDescription())
                .build());
    }

    @Override
    public void deleteHabitById(Long id) {
        habitRepository.deleteById(id);
    }

    @Override
    public void editHabit(Habit habit) {
        habitRepository.save(habit);
    }
}
