package com.ty.BirthdayApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BirthdayApp.dto.User;
import com.ty.BirthdayApp.repository.UserRepository;

@Repository
public class UserDao {

	private static final Optional<User> User = null;
	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public String deleteUser(int id) {
		Optional<User> optional = userRepository.findById(id);

		if (optional.isPresent()) {
			userRepository.delete(optional.get());
			return "Person data has been deleted successfully";
		} else {
			return "Person with this ID doesn't exist";
		}
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User login(User user) {
		return (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()));

	}

	public List<User> getAllUsersByRole(String role) {
		return userRepository.findByRole(role);
	}

}
