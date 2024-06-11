package com.bike.on.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bike.on.rent.model.User;

@Repository  // It makes a repository layer and it used for communicating with database
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);    // JpaRepository<Entity Class, primary Key of Entity class>

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
