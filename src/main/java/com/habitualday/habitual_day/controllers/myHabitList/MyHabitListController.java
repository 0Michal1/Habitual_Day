package com.habitualday.habitual_day.controllers.myHabitList;

import com.habitualday.habitual_day.services.intefaces.MyHabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myHabit/list")
public class MyHabitListController {
    private final MyHabitService myHabitService;
    @GetMapping
    public String prepareView(Model model){
        model.addAttribute("myHabits", myHabitService.findAllUserMyHabitList());
        return "/myHabit/list";
    }
}
