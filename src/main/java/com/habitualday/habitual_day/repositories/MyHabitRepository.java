package com.habitualday.habitual_day.repositories;


import com.habitualday.habitual_day.entities.MyHabit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyHabitRepository extends JpaRepository<MyHabit, Long> {
}
