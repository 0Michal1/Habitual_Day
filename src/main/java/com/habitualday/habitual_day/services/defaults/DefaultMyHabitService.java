package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.controllers.myHabitCreate.MyHabitCreateModel;
import com.habitualday.habitual_day.controllers.myHabitList.MyHabitListModel;
import com.habitualday.habitual_day.controllers.myHabitPanel.MyHabitPanelModel;
import com.habitualday.habitual_day.entities.Category;
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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.TreeMap;

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
        habit.setUserCounter(habit.getUserCounter()+1);
        MyHabit myHabit = new MyHabit();
        myHabit.setHabit(habit);
        myHabit.setResolution(LocalDate.now(), myHabitCreateModel.getResolution());
        myHabit.setUser(user);
        myHabitRepository.save(myHabit);

    }

    @Override
    public List<MyHabitListModel> findAllUserMyHabitList() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<String> categoryNames;




        return myHabitRepository.findAllByUser_Username(username).stream()
                .map(myHabit -> MyHabitListModel.builder()
                        .habitId(myHabit.getHabit().getId())
                        .name(myHabit.getHabit().getName())
                        .categoriesNames(myHabit.getHabit().getCategories()
                                .stream().map(Category::getName)
                                .collect(Collectors.toList()))
                        .typeName(myHabit.getHabit().getType().getName())
                        .description(myHabit.getHabit().getDescription())
                        .myHabitId(myHabit.getId())
                        .actualStreak(myHabit.getActualStreak())
                        .maxStreak(myHabit.getMaxStreak())
                        .resolution(myHabit.getResolution().get(myHabit.getResolution().keySet()
                                .stream().max(LocalDate::compareTo).get()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MyHabitPanelModel findUserMyHabit(Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return  myHabitRepository.findByIdAndUser_Username(id, username)
                .map(myHabit -> MyHabitPanelModel.builder()
                        .habitId(myHabit.getHabit().getId())
                        .name(myHabit.getHabit().getName())
                        .categoriesNames(myHabit.getHabit().getCategories()
                                .stream().map(Category::getName)
                                .collect(Collectors.toList()))
                        .typeName(myHabit.getHabit().getType().getName())
                        .description(myHabit.getHabit().getDescription())
                        .myHabitId(myHabit.getId())
                        .actualStreak(myHabit.getActualStreak())
                        .maxStreak(myHabit.getMaxStreak())
                        .resolution(myHabit.getResolution().get(myHabit.getResolution().keySet()
                                .stream().max(LocalDate::compareTo).get()))
                        .streak(myHabit.getStreak())
                        .build()).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public void updateStreak(Long id) {
        MyHabit myHabit = myHabitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        myHabit.setStreak(LocalDate.now(), "done");
        myHabit.setActualStreak(myHabit.getStreak().size());
        if (myHabit.getActualStreak()> myHabit.getMaxStreak()){
            myHabit.setMaxStreak(myHabit.getActualStreak());
        }
    }

}
