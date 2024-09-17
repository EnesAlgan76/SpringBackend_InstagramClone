package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.Follower;
import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFollowerRepository extends JpaRepository<Follower,Integer> {

    Follower findByFollowerAndFollowed(User follower, User followed);

    //boolean existsByFollowerAndFollowed(User follower, User followed);

    boolean existsByFollower_UserIdAndFollowed_UserId(String followerId, String followedId);

    @Query("SELECT f.followed.userId FROM Follower f WHERE f.follower.userId = :userId")
    List<String> getFollowedUserIds(String userId);



}
