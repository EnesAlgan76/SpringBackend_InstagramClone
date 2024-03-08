package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.Follower;
import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFollowerRepository extends JpaRepository<Follower,Integer> {

    Follower findByFollowerAndFollowed(User follower, User followed);

    //boolean existsByFollowerAndFollowed(User follower, User followed);

    boolean existsByFollower_UserIdAndFollowed_UserId(String followerId, String followedId);
}
