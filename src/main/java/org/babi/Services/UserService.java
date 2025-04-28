package org.babi.Services;

import org.babi.Dtos.UserDto.UserLoginDto;
import org.babi.Dtos.UserDto.UserRegisterDto;
import org.babi.Exceptions.InvalidCredentialsException;
import org.babi.Exceptions.UserIsBannedException;
import org.babi.Exceptions.UserNameTakenException;
import org.babi.Exceptions.UserNotFoundException;
import org.babi.Models.BasicUser;
import org.babi.Models.User;
import org.babi.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidationService validationService;

    public UserService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }
    public BasicUser register(UserRegisterDto userRegisterDto) {
        validationService.validateUserRegister(userRegisterDto);
        if(userRepository.findByUsername(userRegisterDto.getUsername()).isPresent()) throw new UserNameTakenException("Username taken");
        BasicUser basicUser = new BasicUser();
        basicUser.setUsername(userRegisterDto.getUsername());
        basicUser.setPassword(userRegisterDto.getPassword());
        basicUser.setRole(userRegisterDto.getRole().toUpperCase());
        return userRepository.save(basicUser);
    }
    public User login(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername()).orElseThrow(() -> new UserNotFoundException("User not found"));
        if(!user.getPassword().equals(userLoginDto.getPassword())) throw new InvalidCredentialsException("invalid credentials");
        if(user.isBanned()) throw new UserIsBannedException("user is already ban");
        return user;
    }
    public void banUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setBanned(true);
        userRepository.save(user);
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
