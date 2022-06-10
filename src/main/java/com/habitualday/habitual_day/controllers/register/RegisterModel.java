package com.habitualday.habitual_day.controllers.register;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString(exclude = "password")
public class RegisterModel {
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    private String password;

}
