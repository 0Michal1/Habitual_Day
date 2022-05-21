package com.habitualday.habitual_day.services.intefaces;

import com.habitualday.habitual_day.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TypeService {
    List<Type> findAllTypes();
    Optional<Type> findTypeById(Long id);
    Optional<Type> findTypeByName(String name);
}
