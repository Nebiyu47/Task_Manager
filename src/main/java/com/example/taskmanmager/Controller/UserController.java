package com.example.taskmanmager.Controller;

import com.example.taskmanmager.Dto.UserDto;
import com.example.taskmanmager.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<UserDto>>getAllUser(){
        List<UserDto> users= userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Long userId) {
        UserDto user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{userId}")
    public ResponseEntity<Void>updateUser(@PathVariable Long userId, @RequestBody UserDto userDto){
        userDto.setUserId(userId);
        userService.updated(userDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletedUser(@PathVariable Long userId){
        userService.deletedUser(userId);
        return ResponseEntity.ok().build();
    }
}
