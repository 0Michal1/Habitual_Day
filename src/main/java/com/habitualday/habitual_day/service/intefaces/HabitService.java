package com.habitualday.habitual_day.service.intefaces;

import com.habitualday.habitual_day.controller.createHabit.CreateHabitModel;
import com.habitualday.habitual_day.entity.Habit;
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
