package com.project.graphQLpractice.domain.user.repository;

import com.project.graphQLpractice.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
