package com.habitualday.habitual_day.repository;

import com.habitualday.habitual_day.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    Optional<Habit> findByName(String name);
}
