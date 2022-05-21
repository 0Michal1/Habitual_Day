package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.entities.Type;
import com.habitualday.habitual_day.repositories.TypeRepository;
import com.habitualday.habitual_day.services.intefaces.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DefaultTypeService implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public List<Type> findAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findTypeById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public Optional<Type> findTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}
