package com.digipay.usermanagement.controller;

import com.digipay.usermanagement.model.entity.*;
import com.digipay.usermanagement.repository.*;
import com.digipay.usermanagement.service.*;
import jakarta.jws.WebService;

import java.util.List;
@WebService(endpointInterface = "com.digipay.usermanagement.controller.UserWS")
public class UserWSImpl implements UserWS {
    @Override
    public void createUser(String username, String userNationalID,Long userRoleId) {
        UserRepository userRepository =new UserRepository();
        BaseService<User> userService = new UserService(userRepository);
        User user=new User();
        Role role=new Role();
        user.setUsername(username);
        user.setNationalID(userNationalID);
        role.setRoleID(userRoleId);
        user.setRole(role);
        userService.create(user);
    }

    @Override
    public List<User> listUsers() {
        UserRepository userRepository =new UserRepository();
        BaseService<User> userService = new UserService(userRepository);
        User user=new User();
        List<User> userList = userService.listAll(user);
        for (User userObject : userList) {
            System.out.printf(userObject.toString());
        }
        return userList;
    }

    @Override
    public void updateUser(Long userID, String username, String userNationalID, Long userRoleId) {
        UserRepository userRepository =new UserRepository();
        BaseService<User> userService = new UserService(userRepository);
        User user=new User();
        Role role=new Role();
        user.setUserID(userID);
        user.setUsername(username);
        user.setNationalID(userNationalID);
        role.setRoleID(userRoleId);
        user.setRole(role);
        userService.update(user);
    }

    @Override
    public void deleteUser(Long userID) {
        UserRepository userRepository =new UserRepository();
        BaseService<User> userService = new UserService(userRepository);
        User user=new User();
        user.setUserID(userID);
        userService.delete(user);
    }
}
