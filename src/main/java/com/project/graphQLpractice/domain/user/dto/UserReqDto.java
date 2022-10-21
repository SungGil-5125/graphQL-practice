package com.project.graphQLpractice.domain.user.dto;

import com.project.graphQLpractice.domain.user.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    public String email;

    public String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
