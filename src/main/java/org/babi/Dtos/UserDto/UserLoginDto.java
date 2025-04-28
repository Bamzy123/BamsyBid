package org.babi.Dtos.UserDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
