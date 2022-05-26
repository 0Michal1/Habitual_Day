package com.habitualday.habitual_day.controllers.habitsCreate;

import com.habitualday.habitual_day.services.intefaces.CategoryService;
import com.habitualday.habitual_day.services.intefaces.HabitService;
import com.habitualday.habitual_day.services.intefaces.TypeService;
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
@RequestMapping("/habits/create")
public class CreateHabitController {
      private final HabitService habitService;
      private final CategoryService categoryService;
      private final TypeService typeService;

      @GetMapping
      public String prepareView(Model model){
            model.addAttribute("createHabitModel", new CreateHabitModel());
            model.addAttribute("categories", categoryService.findAllCategories());
            model.addAttribute("types", typeService.findAllTypes());
           return "/habits/create";
      }

      @PostMapping
      public String processView(@Valid CreateHabitModel createHabitModel, BindingResult result){
            if(result.hasErrors()) {
             return "/habits/create"; }
            habitService.createHabit(createHabitModel);
            return "redirect:/create-habit";
      }

}
