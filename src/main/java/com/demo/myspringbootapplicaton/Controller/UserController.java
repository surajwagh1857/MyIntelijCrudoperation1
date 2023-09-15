package com.demo.myspringbootapplicaton.Controller;
import com.demo.myspringbootapplicaton.Entity.User;
import com.demo.myspringbootapplicaton.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//this is my Crud example for the user class...
public class UserController {
  private final UserService userService;
@Autowired
  public UserController(UserService userService) {

  this.userService = userService;
  }
  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user);
    return ResponseEntity.ok(createdUser);
  }
  @GetMapping("/user")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.updateUser(id, user);
    return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }


}
