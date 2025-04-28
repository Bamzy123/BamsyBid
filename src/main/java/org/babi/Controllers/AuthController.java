package org.babi.Controllers;

import jakarta.validation.Valid;
import org.babi.Dtos.UserDto.UserLoginDto;
import org.babi.Dtos.UserDto.UserRegisterDto;
import org.babi.Models.User;
import org.babi.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody @Valid UserRegisterDto dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public User login(@RequestBody @Valid UserLoginDto dto) {
        return userService.login(dto);
    }
}
