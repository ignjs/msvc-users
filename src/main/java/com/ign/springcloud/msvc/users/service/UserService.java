package com.ign.springcloud.msvc.users.service;

import java.util.List;
import java.util.Optional;
import com.ign.springcloud.msvc.users.entity.User;

public interface UserService {

	Optional<User> findById(Long id);

	User findByUsername(String username);

	List<User> findAll();

	User save(User user);

	Optional<User> update(User user, Long id);

	void deleteById(Long id);
}

