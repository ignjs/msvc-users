package com.ign.springcloud.msvc.users.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ign.springcloud.msvc.users.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Optional<Role> findByName(String name);

}
