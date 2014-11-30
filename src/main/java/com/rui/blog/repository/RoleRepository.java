package com.rui.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rui.blog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
