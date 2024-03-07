package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.dto.PostHomePageDto;
import com.example.SpringBackend_InstagramClone.dto.PostUploadDTO;
import com.example.SpringBackend_InstagramClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT u FROM Post u WHERE u.id = :id")
    Post getPostById(Integer id);

    //p.user.userId, p.user.fullName, p.user.profilePicture, p.content, p.creationDate, p.likeCount


   @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.PostHomePageDto(p.user.userId, p.user.fullName, p.user.profilePicture, p.content, p.creationDate, p.likeCount) FROM Post p WHERE p.postId = :id")
   PostHomePageDto getPostHomePageById(Integer id);

    @Query("SELECT p FROM Post p WHERE p.postId = :id")
    PostUploadDTO findPostById(Integer id);


}
