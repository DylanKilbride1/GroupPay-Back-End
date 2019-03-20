package com.dylankilbride.grouppay.repositories;

import com.dylankilbride.grouppay.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { //JPA or CRUD repo?

	boolean existsByEmailAddress(String emailAddress);
	boolean existsByPassword(String password);
	boolean existsByMobileNumber(String mobileNumber);
	User findUsersByEmailAddress(String emailAddress);
	User findUsersById(long id);
	User findUsersByMobileNumber(String mobileNumber);
}