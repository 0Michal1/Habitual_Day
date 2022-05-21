package com.habitualday.habitual_day.repositories;

import com.habitualday.habitual_day.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findByName(String name);
}
