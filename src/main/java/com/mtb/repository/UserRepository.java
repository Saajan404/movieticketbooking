package com.mtb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mtb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// find user by name
	@Query("from User where userName = :n ")
	List<User> findUserByName(@Param("n") String userName);

	Optional<User> findById(int userId);

	@Query("from User where userEmail = :e")
	public Optional<User> findByEmail(@Param("e") String userEmail);
	

	@Query("from User where  userEmail = :uE OR contact = :c")
	User findByEmailOrContact(@Param("uE") String userEmail,@Param("c") String contact);

}
