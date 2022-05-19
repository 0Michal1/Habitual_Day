package com.habitualday.habitual_day.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Habit> habits;
}
