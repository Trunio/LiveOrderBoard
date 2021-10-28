package com.example.BackendTask.Repositories;

import com.example.BackendTask.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<User, Integer> {
}
