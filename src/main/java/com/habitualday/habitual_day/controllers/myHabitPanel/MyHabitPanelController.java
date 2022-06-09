package com.habitualday.habitual_day.controllers.myHabitPanel;

import com.habitualday.habitual_day.services.intefaces.MyHabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myHabit/panel")
public class MyHabitPanelController {

    private final MyHabitService myHabitService;

    @GetMapping("/{id}")
    public String prepareView(Model model,@PathVariable Long id){
        model.addAttribute("myHabit", myHabitService.findUserMyHabit(id));
        return "/myHabit/panel";
    }
}
