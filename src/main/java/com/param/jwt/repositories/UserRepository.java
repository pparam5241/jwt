package com.param.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.param.jwt.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUserName(String userName);
}
