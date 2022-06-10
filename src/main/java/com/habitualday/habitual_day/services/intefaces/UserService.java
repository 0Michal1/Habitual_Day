package com.habitualday.habitual_day.services.intefaces;

import com.habitualday.habitual_day.controllers.register.RegisterModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void addNewUser(RegisterModel registerModel);
}
