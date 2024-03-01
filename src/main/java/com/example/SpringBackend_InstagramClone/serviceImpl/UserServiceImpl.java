package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.StudentModel;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.service.UserService;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) {
        try {
            Optional<User> userModel = userRepository.findById(userId);
            if (userModel.isPresent()) {
                User user = userModel.get();
                System.out.println("***** BAŞARILI ***** USER :" + user);
                return user;
            } else {
                System.out.println("***** BAŞARISIZ ***** USER BULUNAMADI :");
                return null;
            }
        } catch (Exception e) {
            System.out.println("***** HATA *****:" + e.getMessage());
            return null;
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean findUserByUserNameOrEmail(String fullName, String email) {
        return userRepository.findByUserNameOrEmail(fullName, email);
    }
}
