package com.ign.springcloud.msvc.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.ign.springcloud.msvc.users.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
