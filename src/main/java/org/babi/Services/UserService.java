package org.babi.Services;

import org.babi.Dtos.UserDto.UserRegisterDto;
import org.babi.Exceptions.UserNameTakenException;
import org.babi.Models.User;
import org.babi.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidationService validationService;

    public UserService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }
    public User register(UserRegisterDto userRegisterDto) {
        validationService.validateUserRegister(userRegisterDto);
        if(userRepository.findByUsername(userRegisterDto.getUsername()).isPresent()) {
            throw new UserNameTakenException("Username taken");
        }
    }
}
