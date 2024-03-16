package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.dto.PostHomePageDto;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT u FROM Post u WHERE u.id = :id")
    Post getPostById(Integer id);

    @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.PostHomePageDto(p.id, p.user.userId, p.user.fullName, p.user.profilePicture, p.content, p.creationDate, p.likeCount, p.explanation, p.user.userName) FROM Post p WHERE p.postId = :id")
    PostHomePageDto getPostHomePageById(Integer id);


    @Query("SELECT p FROM Post p WHERE p.postId = :id")
    PostDTO findPostById(Integer id);


    @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.PostDTO(p.postId, p.user.userId, p.content, p.explanation, p.creationDate, p.likeCount) FROM Post p WHERE p.user.userId = :userId")
    List<PostDTO> getUserAllPost(String userId);


    @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.PostHomePageDto(p.id, p.user.userId, p.user.fullName, p.user.profilePicture, p.content, p.creationDate, p.likeCount, p.explanation, p.user.userName) FROM Post p WHERE p.user.userId = :userId")

    List<PostHomePageDto> getUserPostsHomePage(String userId);
}
