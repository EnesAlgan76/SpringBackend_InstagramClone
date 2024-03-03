package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserService;
import com.example.SpringBackend_InstagramClone.utils.ConsolePrinter;
import org.springframework.http.ResponseEntity;
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
    public boolean checkUserExists(String userName, String email, String phoneNumber) {
        if(email.isBlank()){
            ConsolePrinter.printYellow("Mail Boş, Telefon ile kontrol ediliyor");
            return userRepository.checkUserNameAndTelExists(userName, phoneNumber);

        }else{
            ConsolePrinter.printYellow("Telefon Boş, Mail ile kontrol ediliyor");
            return userRepository.checkUserNameAndEmailExists(userName, email);

        }

    }

    @Override
    public BaseResponse authenticateUser(String userNameOrTelOrMail, String password) {
        User user = userRepository.findByUsernameAndPassword(userNameOrTelOrMail, password);
        if (user != null) {
            return new BaseResponse(true,"findByUsernameAndPassword",user);
        }

        user = userRepository.findByEmailAndPassword(userNameOrTelOrMail, password);
        if (user != null) {
            return new BaseResponse(true,"findByEmailAndPassword",user);
        }

        user = userRepository.findByPhoneNumberAndPassword(userNameOrTelOrMail, password);
        if (user != null) {
            return new BaseResponse(true,"findByPhoneNumberAndPassword",user);
        }

        return new BaseResponse(false,"No user found",null);

    }




    @Override
    public BaseResponse updateFcmToken(String userId, String newFcmToken) {
        int updatedCount = userRepository.updateFcmToken(userId, newFcmToken);

        if(updatedCount>0){
            return new BaseResponse(true,"FCM Token Güncellendi", null);
        }else {
            return new BaseResponse(false,"Güncellenecek Kullanıcı Bulunamadı", null);
        }
    }



}
