package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.controllers.myHabitCreate.MyHabitCreateModel;
import com.habitualday.habitual_day.entities.Habit;
import com.habitualday.habitual_day.entities.MyHabit;
import com.habitualday.habitual_day.entities.User;
import com.habitualday.habitual_day.repositories.HabitRepository;
import com.habitualday.habitual_day.repositories.MyHabitRepository;
import com.habitualday.habitual_day.repositories.UserRepository;
import com.habitualday.habitual_day.services.intefaces.MyHabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMyHabitService implements MyHabitService {
    private final MyHabitRepository myHabitRepository;
    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    @Override
    public void createMyHabit(MyHabitCreateModel myHabitCreateModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Habit habit = habitRepository.findById(myHabitCreateModel.getHabitId()).get();
        User user = userRepository.findByUsername(username).get();
        MyHabit myHabit = new MyHabit();
        myHabit.setHabit(habit);
        myHabit.setResolution(LocalDate.now(), myHabitCreateModel.getResolution());
        myHabit.setUser(user);
        myHabitRepository.save(myHabit);

    }
}
