package com.weirdo.courses.interfaces;

import java.util.List;
import java.util.Set;

import com.weirdo.courses.model.User;

public interface UserDao {
	
	Set<User> getAllUsers();
	User loginUser(User user);
	boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
