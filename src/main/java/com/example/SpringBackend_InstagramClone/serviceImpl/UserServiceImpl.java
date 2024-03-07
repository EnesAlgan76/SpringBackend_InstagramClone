package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserService;
import com.example.SpringBackend_InstagramClone.utils.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse getUserById(String userId) {
        try {
            User userModel = userRepository.findUserByIdWithoutPosts(userId);
            if (userModel != null) {
                System.out.println("***** BAŞARILI ***** USER :" + userModel);
                return new BaseResponse(true, "BAŞARILI", userModel );
            } else {
                return new BaseResponse(false, "USER BULUNAMADI", userModel );
            }
        } catch (Throwable e) {
            return new BaseResponse(false, "HATA", e );
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
