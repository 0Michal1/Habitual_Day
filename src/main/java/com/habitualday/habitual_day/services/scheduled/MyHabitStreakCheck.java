package com.habitualday.habitual_day.services.scheduled;

import com.habitualday.habitual_day.entities.MyHabit;
import com.habitualday.habitual_day.repositories.MyHabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class MyHabitStreakCheck {
    private final MyHabitRepository myHabitRepository;

    @Scheduled(cron = "1 0 0 * * *")
    public void myHabitStreakCheck(){
        List<MyHabit> allUsersMyHabits = myHabitRepository.findAll();
        for (MyHabit myHabit : allUsersMyHabits) {
            Map<LocalDate, String> streak = myHabit.getStreak();
        if(!streak.containsKey(LocalDate.now().minusDays(1))) {myHabit.setStreak(new HashMap<>());
        myHabit.setActualStreak(0);}

        }

    }
}
