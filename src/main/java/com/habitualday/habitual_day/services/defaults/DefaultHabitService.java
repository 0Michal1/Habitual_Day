package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.controllers.habitsCreate.CreateHabitModel;
import com.habitualday.habitual_day.controllers.habitsList.HabitsListModel;
import com.habitualday.habitual_day.entities.Category;
import com.habitualday.habitual_day.entities.Habit;
import com.habitualday.habitual_day.repositories.CategoryRepository;
import com.habitualday.habitual_day.repositories.HabitRepository;
import com.habitualday.habitual_day.services.intefaces.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class DefaultHabitService implements HabitService {
    private final HabitRepository habitRepository;
    private  final CategoryRepository categoryRepository;

    @Override
    public List<Habit> findAllHabits() {
        return habitRepository.findAll();
    }

    public List<HabitsListModel> findAllHabitsList(){
       List<Habit> habitList = habitRepository.findAll();
       List<HabitsListModel> list = new ArrayList<>();
       for (Habit habit : habitList) {
           list.add(HabitsListModel.builder()
                           .name(habit.getName())
                           .categories(habit.getCategories())
                           .description(habit.getDescription())
                           .type(habit.getType())
                           .userCounter(habit.getUserCounter())
                           .id(habit.getId())
                   .build());
             }
    return list;
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
//      Do zrobienia: Sprawdzenie, czy nie ma już takiego nawyku w bazie

        List <Category> categories = createHabitModel.getCategories();

//      Sprawdzenie, czy wpisał nową kategorię
        if (createHabitModel.getCategoryName() != null){
//            Sprawdzenie, czy kategoria jest w bazie, a jak nie to jej utworzenie
            Category category = categoryRepository.findByName(createHabitModel.getCategoryName())
                    .orElseGet(()->categoryRepository.save(Category.builder()
                            .name(createHabitModel.getCategoryName())
                            .build()));
            categories.add(category);
        }
//        Zapis nawyku
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
