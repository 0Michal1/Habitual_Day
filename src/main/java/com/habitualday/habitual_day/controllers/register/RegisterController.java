package com.habitualday.habitual_day.controllers.register;

import com.habitualday.habitual_day.controllers.habitsCreate.CreateHabitModel;
import com.habitualday.habitual_day.services.intefaces.UserService;
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
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    @GetMapping
    public String prepareView(Model model){
        model.addAttribute("registerModel", new RegisterModel());

        return "/general/register";
    }

    @PostMapping
    public String processView(@Valid RegisterModel registerModel, BindingResult result){
        if(result.hasErrors()) {
            return "/general/register"; }
        userService.addNewUser(registerModel);

        return "redirect:/habitualday";
    }
}
