package com.tweetapp.demo.models;

import com.tweetapp.demo.dtomodels.UserLoginDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "User")
public class User {

    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate date;
    private String mobile;
    @Id
    private String email;
    private String nickname;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
