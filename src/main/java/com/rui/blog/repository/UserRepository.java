package com.rui.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rui.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
