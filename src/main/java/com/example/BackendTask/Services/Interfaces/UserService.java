package com.example.BackendTask.Services.Interfaces;

import com.example.BackendTask.Models.User;

import java.util.List;

public interface UserService {
    public abstract User addUser(String user);
    public abstract List<User> getUsers();
}
