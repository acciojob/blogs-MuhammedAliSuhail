package com.driver.controller;

import com.driver.models.User;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userservices;
    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestParam String username, @RequestParam String password) {
        // create a new user with given username and password
    userservices.createUser(username,password);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        // delete user using deleteById
        try {
            userservices.deleteUser(userId);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestParam Integer id, @RequestParam String password) {
        // update password of given user
        try{
            userservices.updateUser(id,password);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
