package com.habitualday.habitual_day.controllers.myHabitStreak;

import com.habitualday.habitual_day.services.intefaces.MyHabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myHabit/streak")
public class MyHabitStreakController {

    private final MyHabitService myHabitService;
    @GetMapping("/{id}")
    public String prepareView(Model model, @PathVariable Long id){
        myHabitService.findUserMyHabit(id);
        myHabitService.updateStreak(id);
        return "redirect:/myHabit/list";
    }
}
