package org.babi.Dtos.UserDto;

import jakarta.validation.constraints.NotBlank;

public class userLoginDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
