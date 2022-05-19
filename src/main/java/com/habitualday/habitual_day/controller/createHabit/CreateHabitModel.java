package com.habitualday.habitual_day.controller.createHabit;

import com.habitualday.habitual_day.entity.Category;

import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateHabitModel {
    @NotBlank @Length(min =3, max = 100)
    private String name;
    @NotBlank
    private String description;
    private Long typeId;
    private List<Long> categoriesId;
    private String categoryName;


}
