package com.example.taskmanmager.Service;

import com.example.taskmanmager.Dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    void addUser(UserDto userDto);
    void  updated(UserDto userDto, Long id);
    void deletedUser(Long userId);
}
