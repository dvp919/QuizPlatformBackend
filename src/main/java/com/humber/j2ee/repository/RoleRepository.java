package com.humber.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.j2ee.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
