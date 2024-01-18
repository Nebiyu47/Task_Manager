package com.example.taskmanmager.Service.Implemnation;

import com.example.taskmanmager.Dto.UserDto;
import com.example.taskmanmager.DtoAddpater.UserAdapter;
import com.example.taskmanmager.Entity.User;
import com.example.taskmanmager.Service.UserService;
import com.example.taskmanmager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final UserAdapter userAdapter;



    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();
        return users.stream().map(userAdapter::UserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long userId) {
       User user = userRepository.findById(userId).orElse(null);
       if(user!=null){
           return userAdapter.UserToUserDto(user);
       }
       return null;

    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        // ... set other properties

        userRepository.save(user);
    }

    @Override
    public void updated(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElse(null);
        if (user != null) {
            User updatedUser = userAdapter.UserDtoToUser(userDto);
            userRepository.save(updatedUser);  // Save the updatedUser, not the original user
        }
    }

    @Override
    public void deletedUser(Long userId) {
       userRepository.deleteById(userId);
    }
}
