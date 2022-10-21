package com.project.graphQLpractice.domain.user.service;

import com.project.graphQLpractice.domain.user.User;
import com.project.graphQLpractice.domain.user.dto.UserReqDto;
import com.project.graphQLpractice.domain.user.dto.UserResDto;
import com.project.graphQLpractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResDto registerUser(UserReqDto userParam) {
        log.info(userParam.getEmail());
        log.info(userParam.getPassword());
        User user = userParam.toEntity();
        userRepository.save(user);
        return UserResDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Transactional
    public boolean delete(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));
        if(user==null) {
            return false;
        } else {
            userRepository.delete(user);
            return true;
        }
    }

    @Transactional(readOnly = true)
    public UserResDto findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        return UserResDto.builder()
                .userId(userId)
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
