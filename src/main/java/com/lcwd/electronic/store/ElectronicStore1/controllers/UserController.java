package com.lcwd.electronic.store.ElectronicStore1.controllers;

import com.lcwd.electronic.store.ElectronicStore1.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore1.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @PutMapping("/userId")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId,@Valid @RequestBody UserDto userDto) {
        UserDto udatedUserDto = userService.updateUser(userDto,userId);
        return new ResponseEntity<>(udatedUserDto, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId)
    {
     userService.deleteUser(userId);
        /*ApiResponseMessage message = ApiResponseMessage.
                builder().
                message("User is deleted Successfully !!").success(true)
                .status(HttpStatus.OK).build();*/
        return new ResponseEntity<>("User is Delelted Successfully !!", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("email/{userId}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
    {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords)
    {
        return new ResponseEntity<>(userService.search(keywords), HttpStatus.OK);
    }
}
