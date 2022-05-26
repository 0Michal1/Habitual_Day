package com.habitualday.habitual_day.controllers.myHabitCreate;

import com.habitualday.habitual_day.controllers.habitsCreate.CreateHabitModel;
import com.habitualday.habitual_day.services.intefaces.MyHabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myHabit/create")
public class MyHabitCreateController {
    private final MyHabitService myHabitService;

    @GetMapping
    public String prepareView(Model model){
        model.addAttribute("createMyHabitModel", new MyHabitCreateModel());

        return "/myHabit/create";
    }
    @GetMapping("/{id}")
    public String prepareViewWithId(Model model, @PathVariable String id){
        model.addAttribute("createMyHabitModel", new MyHabitCreateModel());
        model.addAttribute("habitId",id);

        return "/myHabit/create";
    }
    @PostMapping
    public String processView(@Valid MyHabitCreateModel myHabitCreateModel, BindingResult result){
        if(result.hasErrors()){
            return "/myHabit/create";
        }
           myHabitService.createMyHabit(myHabitCreateModel);
        return "redirect:/habits/list";
    }


}
