package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT u FROM Post u WHERE u.id = :id")
    Post getPostById(Integer id);


    @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.PostDTO(p.user.userId, p.content, p.creationDate) FROM Post p WHERE p.postId = :id")
    PostDTO findPostDTOById(Integer id);


}
