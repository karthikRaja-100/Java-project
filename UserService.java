package com.example.OnlineBankProcess.Service;

import com.example.OnlineBankProcess.Entity.User;
import com.example.OnlineBankProcess.UserRepo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User registerUser(User user) {

        return userRepository.save(user);
    }
}