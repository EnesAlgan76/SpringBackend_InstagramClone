package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT EXISTS(SELECT 1 FROM User u WHERE u.userName = :userName OR u.email = :email)")
    boolean findByUserNameOrEmail(String userName, String email);
}
