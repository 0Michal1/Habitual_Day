package com.habitualday.habitual_day.controllers.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/habitualday")
public class HomepageController {

    @GetMapping
    public String homepage(){
        return "/homepage";
    }

}
