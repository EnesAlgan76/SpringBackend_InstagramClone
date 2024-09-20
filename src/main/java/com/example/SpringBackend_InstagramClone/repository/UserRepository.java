package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query("SELECT u FROM User u WHERE u.userId = :id")
    User findUserById(String id);


    @Query("SELECT u FROM User u WHERE u.userName = :userNme")
    User findByUserName(String userNme);


    @Query("SELECT u.fcmToken FROM User u WHERE u.userId = :id")
    String getFCMToken(String id);




    //register
    @Query("SELECT EXISTS(SELECT 1 FROM User u WHERE u.userName = :userName OR u.phoneNumber = :phoneNumber)")
    boolean checkUserNameAndTelExists(String userName, String phoneNumber);

    @Query("SELECT EXISTS(SELECT 1 FROM User u WHERE u.userName = :userName OR u.email = :email)")
    boolean checkUserNameAndEmailExists(String userName, String email);


    //login

    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
    User findByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber AND u.password = :password")
    User findByPhoneNumberAndPassword(@Param("phoneNumber") String phoneNumber, @Param("password") String password);



    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.fcmToken = :newFcmToken WHERE u.userId = :userId")
    int updateFcmToken(String userId, String newFcmToken);


    List<User> findByUserNameStartingWith(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.postCount = u.postCount + 1 WHERE u.userId = :userId")
    int incrementPostCount(@Param("userId") String userId);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.followerCount = u.followerCount + 1 WHERE u.userId = :userId")
    void incrementFollowerCount(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.followingCount = u.followingCount + 1 WHERE u.userId = :userId")
    void incrementFollowingCount(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.followingCount = u.followingCount + 1 WHERE u.userId = :userId")
    void deleteByUserId(String userId);
}
