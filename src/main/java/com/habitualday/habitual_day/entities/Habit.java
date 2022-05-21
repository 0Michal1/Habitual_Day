package com.habitualday.habitual_day.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "habits")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString(exclude = "categories")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @ManyToOne
    private Type type;
    @ManyToMany
    private List<Category> categories;
    @Column(name = "user_counter")
    private int userCounter = 0;
    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;
    @Column(name = "updated_on", insertable = false)
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now(Clock.systemUTC());
    }
    @PreUpdate
    public void preUpdate(){
        updatedOn = LocalDateTime.now(Clock.systemUTC());
    }

}
