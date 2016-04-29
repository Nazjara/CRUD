package com.nazjara.service.impl;
import com.nazjara.dao.UserDAO;
import com.nazjara.entity.User;
import com.nazjara.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserDAO userDAO;

    @Override
    public long createUser(User user) {
        return userDAO.createUser(user);
    }
    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }    
    @Override
    public List<User> getAllUsers(String userName) {
    	return userDAO.getAllUsers(userName);
    }
}
