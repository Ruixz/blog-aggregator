package com.rui.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rui.blog.entity.Blog;
import com.rui.blog.entity.Item;
import com.rui.blog.entity.Role;
import com.rui.blog.entity.User;
import com.rui.blog.repository.BlogRepository;
import com.rui.blog.repository.ItemRepository;
import com.rui.blog.repository.RoleRepository;
import com.rui.blog.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogRuan = new Blog();
		blogRuan.setName("Ruan");
		blogRuan.setUrl("http://feeds.feedburner.com/ruanyifeng");
		blogRuan.setUser(userAdmin);
		blogRepository.save(blogRuan);
		
		Item item1 = new Item();
		item1.setBlog(blogRuan);
		item1.setTitle("first");
		item1.setLink("http://www.ruanyifeng.com/blog/");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogRuan);
		item2.setTitle("second");
		item2.setLink("http://www.ruanyifeng.com/blog/");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
	}
}
