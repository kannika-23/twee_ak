package com.tweetapp.demo.dtomodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPasswordDto {
    @NotNull(message = "cannot be null")
    @Pattern(regexp = "[a-zA-Z1-9@#$*%&]{2,6}", message = "userName must be of size of 2 to 8")
    private String nickname;
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;
    @NotNull(message = "Password cannot be empty")
    @Size(min = 8,
            message = "password must be size 10")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String newPassword;
}
