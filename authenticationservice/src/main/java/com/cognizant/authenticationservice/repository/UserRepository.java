package com.cognizant.authenticationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.authenticationservice.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select id from USER where user_name =?", nativeQuery = true)
	Long findIdByUserName(String username);

	@Query(value = "select * from USER where user_name =?", nativeQuery = true)
	User findByUserName(String userName);
}
