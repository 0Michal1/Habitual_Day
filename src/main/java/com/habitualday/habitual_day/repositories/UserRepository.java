package com.habitualday.habitual_day.repositories;


import com.habitualday.habitual_day.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
