package com.ign.springcloud.msvc.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ign.springcloud.msvc.users.entity.Role;
import com.ign.springcloud.msvc.users.entity.User;
import com.ign.springcloud.msvc.users.repository.RoleRepository;
import com.ign.springcloud.msvc.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		log.info("Getting user by id: " + id);
		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		log.info("Getting user by username: " + username);
		return repository.findByUsername(username);
	}

	@Transactional
	public User save(User user) {
		log.info("Creating user: " + user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(getRoles(user));
		user.setEnabled(true);
		return repository.save(user);
	}

	@Transactional
	public void deleteById(Long id) {
		log.info("Deleting user by id: " + id);
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<User> update(User user, Long id) {
		log.info("Updating user by id: " + id);
		Optional<User> existingUser = this.findById(id);
		return existingUser.map(value -> {
			value.setEmail(user.getEmail());
			value.setUsername(user.getUsername());
			if (user.isEnabled() != null) {
				value.setEnabled(true);
			} else {
				value.setEnabled(user.isEnabled());
			}
			value.setRoles(getRoles(user));
			return Optional.of(repository.save(value));
		}).orElseGet(() -> Optional.empty());
	}

	private List<Role> getRoles(User user) {
		log.info("Getting roles for user: " + user);
		List<Role> roles = new ArrayList<>();
		Optional<Role> roleOptional = roleRepository.findByName("ROLE_USER");
		roleOptional.ifPresent(roles::add);
		if (user.isAdmin()) {
			Optional<Role> roleAdmin = roleRepository.findByName("ROLE_ADMIN");
			roleAdmin.ifPresent(roles::add);
		}
		return roles;
	}
}

