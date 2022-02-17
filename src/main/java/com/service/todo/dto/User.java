package com.service.todo.dto;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String emailId;

	private String name;
	private String username;
	private String password;
	private String role;
	boolean active;

	@OneToMany(mappedBy = "author")
	private Set<Todo> todos;

	public User() {
	}

	public User(String username, String password, String userRole) {
		this.username = username;
		this.password = password;
		this.role = userRole;
		this.active = true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return emailId == user.emailId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId);
	}
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Todo> getTodos() {
		return todos;
	}

	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "User [id=" + emailId + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
				+ role + ", active=" + active + ", todos=" + todos + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}