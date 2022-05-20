package com.habitualday.habitual_day.controller.createHabit;

import com.habitualday.habitual_day.entity.Category;

import com.habitualday.habitual_day.entity.Type;
import lombok.*;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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
