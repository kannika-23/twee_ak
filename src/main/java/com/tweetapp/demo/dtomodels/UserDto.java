package com.tweetapp.demo.dtomodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 2, max = 30,
            message = "firstName must be atleast of 2 letters and not more then 100 letters")
    private String firstname;
    @Size(min = 2, max = 30,
            message = "lastName must be atleast of 2 letters and not more then 100 letters")
    private String lastname;
    @NotNull(message = "cannot be null")
    private String gender;
    private LocalDate date;
    @NotNull(message = "cannot be null")
    @Pattern(regexp = "^[987]{1}[0-9]{9}$")
    private String mobile;
    @Id
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;
    @NotNull(message = "cannot be null")
    @Pattern(regexp = "[a-zA-Z1-9@#$*%&]{2,6}", message = "userName must be of size of 2 to 8")
    private String nickname;
    @NotNull(message = "Password cannot be empty")
    @Size(min = 8, max = 10,
            message = "password must be size 10")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

}
