package com.demo.myspringbootapplicaton.SeviceImpl;

import com.demo.myspringbootapplicaton.Entity.User;
import com.demo.myspringbootapplicaton.Repo.UserRepo;
import com.demo.myspringbootapplicaton.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserImpl implements UserService {
private final UserRepo userRepo;
    @Autowired
    public UserImpl(UserRepo userRepo) {
        this.userRepo = userRepo;

    }
    @Override
    public User createUser(User user) {
      return   userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return  userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
       return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepo.existsById(id)) {
            user.setId(id);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
