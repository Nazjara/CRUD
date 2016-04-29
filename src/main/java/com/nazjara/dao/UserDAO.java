package com.nazjara.dao;

import java.util.List;
import com.nazjara.entity.User;


public interface UserDAO {
	long createUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();User getUser(long id);
	List<User> getAllUsers(String userName);
}
