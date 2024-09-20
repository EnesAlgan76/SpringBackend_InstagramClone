package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.StoryDTO;
import com.example.SpringBackend_InstagramClone.dto.UserStoriesDTO;
import com.example.SpringBackend_InstagramClone.model.Story;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.StoryRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    public UserStoriesDTO getUserStories(String userId) {
        User user = userRepository.findUserById(userId);

        List<StoryDTO> storyDTOs = storyRepository.findByUser(user).stream()
                .map(story -> new StoryDTO(story.getStoryId(), story.getStoryImage(), story.getCreationDate()))
                .collect(Collectors.toList());

        return new UserStoriesDTO(user.getUserName(), user.getFullName(), user.getProfilePicture(), storyDTOs);
    }

    @Transactional
    public void addStory(String userId, String storyImage, Long creationDate) {
        User user = userRepository.findUserById(userId);

        Story story = new Story();
        story.setUser(user);
        story.setStoryImage(storyImage);
        story.setCreationDate(creationDate);

        storyRepository.save(story);
    }
}
