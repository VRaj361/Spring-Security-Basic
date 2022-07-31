package com.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserBean;

@Repository
public interface JPARepository extends JpaRepository<UserBean, String>{
	UserBean findByUsername(String username);
	
}
