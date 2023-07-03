package com.example.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static Integer usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Bhishma", LocalDate.now().minusYears(100)));
		users.add(new User(++usersCount, "Karan", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Arjun", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		User user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}

	
}
