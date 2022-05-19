package com.habitualday.habitual_day.repository;


import com.habitualday.habitual_day.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
