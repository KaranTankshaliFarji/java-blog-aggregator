package cz.karan.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.Item;
import cz.karan.jba.entity.Role;
import cz.karan.jba.entity.User;
import cz.karan.jba.repository.BlogRepository;
import cz.karan.jba.repository.ItemRepository;
import cz.karan.jba.repository.RoleRepository;
import cz.karan.jba.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	public User findOne(int id)
	{
		return userRepository.findOne(id);
	}
	@Transactional
	public User findOneWithBlogs(int id)
	{
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog,new PageRequest(0, 10, Direction.ASC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
		
	}
	@Transactional
	public User findOneWithBlogs(String name)
	{
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}
	public void save(User user)
	{
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		//roles.add(roleAdmin);
		user.setRoles(roles); 
		
		userRepository.save(user);
		
	}
	
}
