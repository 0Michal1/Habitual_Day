package com.habitualday.habitual_day.controllers.habitsList;

import com.habitualday.habitual_day.entities.Category;
import com.habitualday.habitual_day.entities.Type;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HabitsListModel {

    private String name;
    private String description;
    private Type type;
    private List<Category> categories;
    private int userCounter;
    private Long id;


}
