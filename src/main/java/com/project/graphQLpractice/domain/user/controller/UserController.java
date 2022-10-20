package com.project.graphQLpractice.domain.user.controller;

import com.project.graphQLpractice.domain.user.User;
import com.project.graphQLpractice.domain.user.dto.UserReqDto;
import com.project.graphQLpractice.domain.user.dto.UserResDto;
import com.project.graphQLpractice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @MutationMapping
    public User save(UserReqDto userParam) {
        log.info("sdfasfasdf");
        return userService.save(userParam);
    }

    @MutationMapping
    public void delete(Long userId) {
        userService.delete(userId);
    }

    @QueryMapping
    public UserResDto findById(Long userId) {
        return userService.findById(userId);
    }

    @QueryMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
