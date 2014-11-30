package com.rui.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rui.blog.entity.Blog;
import com.rui.blog.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
