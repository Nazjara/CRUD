package com.nazjara.controller;
import com.nazjara.entity.User;
import com.nazjara.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("createUser")
    public ModelAndView createUser(@ModelAttribute User user) {
        return new ModelAndView("userForm");
    }
    
    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam long id, @ModelAttribute User user) {
        user = userService.getUser(id);
        return new ModelAndView("userForm", "userObject", user);
    }
    
    @RequestMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        if(user.getId() == 0){
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return new ModelAndView("redirect:getAllUsers");
    }
    
    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:getAllUsers");
    }
    
    @RequestMapping(value = {"getAllUsers", "/"})
    public ModelAndView getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ModelAndView("userList", "userList", userList);
    }
    
    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName) {
    	List<User> userList = userService.getAllUsers(searchName);
        return new ModelAndView("userList", "userList", userList);
    }
}