package com.habitualday.habitual_day.controllers.myHabitPanel;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyHabitPanelModel {
    private String name;
    private String description;
    private String typeName;
    private List<String> categoriesNames;
    private Long habitId;
    private Long myHabitId;
    private String resolution;
    private int maxStreak;
    private int actualStreak;
    private Map <LocalDate, String> streak;

}
