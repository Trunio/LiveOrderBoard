package com.example.BackendTask.Services.Implementations;

import com.example.BackendTask.Models.User;
import com.example.BackendTask.Repositories.UserRepository;
import com.example.BackendTask.Services.Interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User addUser(String user) {
        return userRepository.save(new User(user));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
