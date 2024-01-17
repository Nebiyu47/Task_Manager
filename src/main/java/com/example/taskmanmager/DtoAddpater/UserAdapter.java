package com.example.taskmanmager.DtoAddpater;

import com.example.taskmanmager.Dto.UserDto;
import com.example.taskmanmager.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public  UserDto UserToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(userDto.getUsername());
        userDto.setEmail(userDto.getEmail());
        return userDto;
    }
    public  User UserDtoToUser( UserDto userDto){
        User user= new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
