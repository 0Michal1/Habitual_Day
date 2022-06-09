package com.habitualday.habitual_day.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Entity
@Table(name = "my_habits")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class MyHabit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Habit habit;
    @ManyToOne
    User user;
    @ElementCollection
    Map <LocalDate, String> streak = new HashMap<>();
    int maxStreak;
    private int actualStreak;
    @ElementCollection
    Map <LocalDate, String> resolution = new HashMap<>();


    public void setResolution(LocalDate now, String resolution) {
       this.resolution.put(now, resolution);
    }
    public void setStreak(LocalDate now, String status){this.streak.put(now, status);}
}
