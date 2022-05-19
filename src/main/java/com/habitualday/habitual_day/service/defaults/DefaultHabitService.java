package com.habitualday.habitual_day.service.defaults;

import com.habitualday.habitual_day.controller.createHabit.CreateHabitModel;
import com.habitualday.habitual_day.entity.Habit;
import com.habitualday.habitual_day.repository.HabitRepository;
import com.habitualday.habitual_day.service.intefaces.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DefaultHabitService implements HabitService {
    private final HabitRepository habitRepository;

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
        return Optional.empty();
    }

    @Override
    public void createHabit(CreateHabitModel createHabitModel) {
        Habit habit = new Habit();


        habitRepository.save(habit);
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
