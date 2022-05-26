package com.habitualday.habitual_day.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    List<LocalDateTime> streak;
    int maxStreak;
    @ElementCollection
    Map <LocalDate, String> resolution = new HashMap<>();


    public void setResolution(LocalDate now, String resolution) {
       this.resolution.put(now, resolution);
    }
}
