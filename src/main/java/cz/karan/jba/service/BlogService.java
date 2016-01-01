package cz.karan.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.User;
import cz.karan.jba.repository.BlogRepository;
import cz.karan.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	public void save(Blog blog, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		blogRepository.delete(id);
	}
	public Blog findOne(int id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		// TODO Auto-generated method stub
		blogRepository.delete(blog);
	}

}
