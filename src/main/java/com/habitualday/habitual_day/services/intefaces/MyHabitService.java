package com.habitualday.habitual_day.services.intefaces;

import com.habitualday.habitual_day.controllers.myHabitCreate.MyHabitCreateModel;
import com.habitualday.habitual_day.controllers.myHabitList.MyHabitListModel;
import com.habitualday.habitual_day.controllers.myHabitPanel.MyHabitPanelModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyHabitService {
    void createMyHabit(MyHabitCreateModel myHabitCreateModel);
    List<MyHabitListModel> findAllUserMyHabitList();

    MyHabitPanelModel findUserMyHabit(Long id);

    void updateStreak(Long id);
}
