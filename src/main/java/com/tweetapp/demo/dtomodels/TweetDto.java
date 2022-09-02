package com.tweetapp.demo.dtomodels;

import com.tweetapp.demo.models.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
public class TweetDto {
    @NotNull(message = "cannot be Empty")
    @Size(min=2, max = 150, message = "only 150 characters allowed")
    private String tweetContent;
    @NotNull(message = "cannot be Empty")
    @Size(min=2, max = 150, message = "only 150 characters allowed")
    private String hashTag;
}
