package com.grootan.parking.repository.userrepository;

import com.grootan.parking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
	@Query("select user from User user where user.userName= ?1")
	User findByUserName(String userName);

	@Query("select user from User user where user.email= ?1")
	User findByEmail(String email);
}
