package com.habitualday.habitual_day.repositories;


import com.habitualday.habitual_day.entities.MyHabit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyHabitRepository extends JpaRepository<MyHabit, Long> {

    List<MyHabit> findAllByUser_Username(String username);

    Optional<MyHabit> findByIdAndUser_Username(Long id, String username);

}
