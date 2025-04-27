package org.babi.Dtos.UserDto;

import jakarta.validation.constraints.NotBlank;

public class userRegisterDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String role; // Admin, Bidder, Seller
}
