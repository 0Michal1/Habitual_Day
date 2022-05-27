package com.habitualday.habitual_day.controllers.myHabitList;

import com.habitualday.habitual_day.entities.Category;
import com.habitualday.habitual_day.entities.Type;
import lombok.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyHabitListModel {

    private String name;
    private String description;
    private String typeName;
    private List<String> categoriesNames;
    private Long habitId;
    private Long myHabitId;
    private Map<LocalDate, String> resolution;
    private int maxStreak;
    private int actualStreak;

}
