package com.habitualday.habitual_day.controllers.habitsCreate;

import com.habitualday.habitual_day.entities.Category;

import com.habitualday.habitual_day.entities.Type;
import lombok.*;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class CreateHabitModel {
    @NotBlank @Length(min =3, max = 100)
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Type type;
    private List<Category> categories;
    private String categoryName;


}
