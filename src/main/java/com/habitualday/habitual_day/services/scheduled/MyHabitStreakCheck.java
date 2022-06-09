package com.habitualday.habitual_day.services.scheduled;

import com.habitualday.habitual_day.entities.MyHabit;
import com.habitualday.habitual_day.repositories.MyHabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MyHabitStreakCheck {
    private final MyHabitRepository myHabitRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void myHabitStreakCheck(){
        List<MyHabit> allUsersMyHabits = myHabitRepository.findAll();
    }
}
