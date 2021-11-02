package com.example.BackendTask.services;

import com.example.BackendTask.models.User;
import com.example.BackendTask.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public User addUser(String user) {
        return userRepository.save(new User(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
