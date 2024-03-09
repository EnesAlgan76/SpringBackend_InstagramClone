package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.UserDTO;
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
        User user = userRepository.findUserById(userId);
        if (user == null) {
            return new BaseResponse(false, "No User With ıd: "+userId, null );
        }
        return new BaseResponse(true, "BAŞARILI",  mapUserToDTO(user) );
    }

    private UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserId(user.getUserId());
        userDTO.setFullName(user.getFullName());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPassword(user.getPassword());
        userDTO.setBiography(user.getBiography());
        userDTO.setFollowerCount(user.getFollowerCount());
        userDTO.setFollowingCount(user.getFollowingCount());
        userDTO.setPostCount(user.getPostCount());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setFcmToken(user.getFcmToken());
        return userDTO;
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
