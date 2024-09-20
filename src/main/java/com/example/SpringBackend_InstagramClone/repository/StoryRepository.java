package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.Story;
import com.example.SpringBackend_InstagramClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {
    List<Story> findByUser(User user);
}