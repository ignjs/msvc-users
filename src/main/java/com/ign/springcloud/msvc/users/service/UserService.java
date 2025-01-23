package com.ign.springcloud.msvc.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ign.springcloud.msvc.users.entity.User;
import com.ign.springcloud.msvc.users.repository.UserRepository;

public class UserService implements UserServiceImpl {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Transactional
	public User save(User user) {
		return repository.save(user);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
