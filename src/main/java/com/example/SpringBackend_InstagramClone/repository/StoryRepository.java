package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.dto.StoryDTO;
import com.example.SpringBackend_InstagramClone.model.Story;
import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {
    List<Story> findByUser(User user);


    @Query("SELECT s " +
            "FROM Story s JOIN Follower f ON s.user.userId = f.followed.userId " +
            "WHERE f.follower.userId = :userId " +
            "ORDER BY s.creationDate DESC")
    List<Story> getStoriesOfFollowedUsers(@Param("userId") String userId);



}