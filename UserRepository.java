package com.example.OnlineBankProcess.UserRepo;

import com.example.OnlineBankProcess.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
