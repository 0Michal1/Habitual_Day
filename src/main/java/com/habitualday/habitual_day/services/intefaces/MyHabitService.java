package com.habitualday.habitual_day.services.intefaces;

import com.habitualday.habitual_day.controllers.myHabitCreate.MyHabitCreateModel;
import org.springframework.stereotype.Service;

@Service
public interface MyHabitService {
    void createMyHabit(MyHabitCreateModel myHabitCreateModel);
}
