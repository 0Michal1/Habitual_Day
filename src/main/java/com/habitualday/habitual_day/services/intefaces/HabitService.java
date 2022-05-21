package com.habitualday.habitual_day.services.intefaces;

import com.habitualday.habitual_day.controllers.createHabit.CreateHabitModel;
import com.habitualday.habitual_day.entities.Habit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HabitService {
    List<Habit> findAllHabits();
    Optional<Habit> findHabitById(Long id);
    Optional<Habit> findHabitByName(String name);
    void createHabit(CreateHabitModel createHabitModel);
    void deleteHabitById(Long id);
    void editHabit(Habit habit);


}
