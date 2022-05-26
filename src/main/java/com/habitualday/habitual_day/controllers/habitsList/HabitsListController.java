package com.habitualday.habitual_day.controllers.habitsList;

import com.habitualday.habitual_day.entities.Habit;
import com.habitualday.habitual_day.services.intefaces.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/habits/list")
@RequiredArgsConstructor
public class HabitsListController {
    private final HabitService habitService;


    @GetMapping
    public String habitsList(Model model){
        List<HabitsListModel> list = habitService.findAllHabitsList();
        model.addAttribute("habits", list);
        return "/habits/list";
    }
}
