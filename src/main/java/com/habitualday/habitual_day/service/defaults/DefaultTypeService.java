package com.habitualday.habitual_day.service.defaults;

import com.habitualday.habitual_day.entity.Type;
import com.habitualday.habitual_day.repository.TypeRepository;
import com.habitualday.habitual_day.service.intefaces.TypeService;
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
