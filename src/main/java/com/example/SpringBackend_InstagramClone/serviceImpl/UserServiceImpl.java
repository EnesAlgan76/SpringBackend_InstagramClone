package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.FilterDTO;
import com.example.SpringBackend_InstagramClone.dto.UserSummaryDTO;
import com.example.SpringBackend_InstagramClone.dto.UserMapper;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserService;
import com.example.SpringBackend_InstagramClone.utils.ConsolePrinter;
import com.example.SpringBackend_InstagramClone.utils.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
        return new BaseResponse(true, "BAŞARILI", UserMapper.mapUserToDTO(user) );
    }


    @Override
    public List<UserSummaryDTO> searchUsersByUsername(String username) {
        List<User> users = userRepository.findByUserNameStartingWith(username);
        List<UserSummaryDTO> list =  users.stream().map(UserMapper::mapUserToListItemDTO)
                .collect(Collectors.toList());
        return list;
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
        System.out.println(userNameOrTelOrMail +"----"+ password);
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
    public List<User> getUsersByFilter(List<FilterDTO> filterDTOList) {
        return userRepository.findAll(UserSpecification.columnEqual(filterDTOList));
    }

    @Override
    public Page<User> getUsersByFilterWithPaggination(List<FilterDTO> filterDTOList, int page, int size) {
        if(page < 1)
            page = 1;

        if(size < 1)
            size = 10;

        Pageable pageable = PageRequest.of(page-1, size, Sort.by("id").descending());
        return userRepository.findAll(UserSpecification.columnEqual(filterDTOList),pageable);
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

    @Override
    public BaseResponse incrementPostCount(String userId) {
        int updatedCount = userRepository.incrementPostCount(userId);

        if(updatedCount>0){
            return new BaseResponse(true,"Post Sayısı Güncellendi", null);
        }else {
            return new BaseResponse(false,"Güncellenecek Post için Kullanıcı Bulunamadı", null);
        }
    }

    @Override
    public BaseResponse getFCMToken(String userId) {
        String fcmToken = userRepository.getFCMToken(userId);
        if (fcmToken != null) {
            return new BaseResponse(true, "Kullanıcı bulundu, token getiriliyor...", fcmToken);
        }
        return new BaseResponse(false, "No User or fcmToken With ıd: "+userId, null );
    }

    @Override
    public BaseResponse incrementFollowerCount(String userId) {
        try {
            userRepository.incrementFollowerCount(userId);
            return new BaseResponse(true, "Incremented follower count",null);
        } catch (Exception e) {
            return new BaseResponse(false, "Error: "+e.getMessage(),null);
        }
    }

    @Override
    public BaseResponse incrementFollowCount(String userId) {
        try {
            userRepository.incrementFollowingCount(userId);
            return new BaseResponse(true, "Incremented following count",null);
        } catch (Exception e) {
            return new BaseResponse(false, "Error: "+e.getMessage(),null);
        }
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteByUserId(userId);
    }

    @Transactional
    public BaseResponse updateUserProfile(String userName, String newFullName, String newUserName, String newBiography, String newSelectedImageUri) {
        User user = userRepository.findByUserName(userName);

        if (user == null) {
            return new BaseResponse(false,"User not found",null);
        }

        if (newUserName != null) {
            if (userRepository.findByUserName(newUserName) != null) {
                return new BaseResponse(false,"Username already exists",null);
            }
            user.setUserName(newUserName);
        }

        if (newFullName != null) {
            user.setFullName(newFullName);
        }

        if (newBiography != null) {
            user.setBiography(newBiography);
        }


        if (newSelectedImageUri != null) {
            user.setProfilePicture(newSelectedImageUri);
        }
        try {
            userRepository.save(user);
            return new BaseResponse(true,"User updated succesfully",null);
        }catch (Exception e){
            return new BaseResponse(false,"Error occoured",null);
        }





    }


}
