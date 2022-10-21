package com.project.graphQLpractice.domain.user.controller;

import com.project.graphQLpractice.domain.user.User;
import com.project.graphQLpractice.domain.user.dto.UserReqDto;
import com.project.graphQLpractice.domain.user.dto.UserResDto;
import com.project.graphQLpractice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @MutationMapping
    public UserResDto registerUser(@Argument UserReqDto userParam) {
        return userService.registerUser(userParam);
    }

    @MutationMapping
    public void delete(@Argument Long userId) {
        userService.delete(userId);
    }

    @QueryMapping
    public UserResDto findUserById(@Argument Long userId) {
        return userService.findById(userId);
    }

    @QueryMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
