package cz.karan.jba.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
 
		@Id
		@GeneratedValue
		private Integer id;
		
		@Size(min=3,message = "User Name must be atleast 3 characters long")
		private String name;
		
		@Size(min=1,message = "Invalid Email")
		@Email(message = "Invalid Email")
		private String email;
		private boolean enabled;
		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		@Size(min=5,message = "Password must be atleast 5 characters long")
		private String password;
		@ManyToMany
		@JoinTable
		private List<Role> roles;

		@OneToMany(mappedBy="user" , cascade = CascadeType.REMOVE)
		private List<Blog> blogs;
		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

		public List<Blog> getBlogs() {
			return blogs;
		}

		public void setBlogs(List<Blog> blogs) {
			this.blogs = blogs;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		
}
