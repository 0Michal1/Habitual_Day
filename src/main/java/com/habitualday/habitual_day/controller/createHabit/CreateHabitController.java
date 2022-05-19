package com.habitualday.habitual_day.controller.createHabit;

import com.habitualday.habitual_day.service.intefaces.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/create-habit")
public class CreateHabitController {
      private final HabitService habitService;


      @GetMapping
      public String prepareView(Model model){
            model.addAttribute("createHabitModel", new CreateHabitModel());
           return "/habits/create";
      }

      @PostMapping
      public String processView(@Valid CreateHabitModel createHabitModel, BindingResult result){
            if(result.hasErrors()) {
             return "/habits/create"; }
            habitService.createHabit(createHabitModel);

            return "";
      }

}
