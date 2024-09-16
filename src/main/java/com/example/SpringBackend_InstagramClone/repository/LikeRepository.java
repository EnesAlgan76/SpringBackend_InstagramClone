package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like,Integer> {

    @Query("SELECT count(l) > 0 FROM Like l WHERE l.userId = :userId AND l.postId = :postId")

    boolean existsByUserIdAndPostId(String userId, Integer postId);

    @Modifying
    @Query("DELETE FROM Like l WHERE l.userId = :userId AND l.postId = :postId")
    void deleteByUserIdAndPostId(String userId, Integer postId);


}
