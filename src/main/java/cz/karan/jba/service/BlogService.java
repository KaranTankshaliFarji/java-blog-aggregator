package cz.karan.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.Item;
import cz.karan.jba.entity.User;
import cz.karan.jba.exception.RssException;
import cz.karan.jba.repository.BlogRepository;
import cz.karan.jba.repository.ItemRepository;
import cz.karan.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemRepository itemRepository;
	public void save(Blog blog, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
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
	
	public void saveItems(Blog blog)
	{
		try
		{
		List<Item> items = rssService.getItems(blog.getUrl());
		for (Item item : items) {
			Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
			if(savedItem == null)
			{	
			item.setBlog(blog);
			itemRepository.save(item);
			}
		}
		}
		catch(RssException e)
		{
			e.printStackTrace();
		}
	}
	//1 hour
	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs()
	{
		List<Blog> blogs = blogRepository.findAll();
		for (Blog blog : blogs) {
			saveItems(blog);
		}
	}
}
