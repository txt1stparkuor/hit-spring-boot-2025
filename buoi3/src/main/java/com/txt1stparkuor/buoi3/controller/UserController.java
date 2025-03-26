package com.txt1stparkuor.buoi3.controller;

import com.txt1stparkuor.buoi3.entity.User;
import com.txt1stparkuor.buoi3.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @PostMapping
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    String getUser() {
        return "1";
    }

}
