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
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    public UserStoriesDTO getUserStories(String userId) {
        User user = userRepository.findUserById(userId);

        List<StoryDTO> storyDTOs = storyRepository.getStoriesOfFollowedUsers(user.getUserId()).stream()
                .map(story -> new StoryDTO(story.getStoryId(), story.getStoryImage(), story.getCreationDate()))
                .collect(Collectors.toList());

        return new UserStoriesDTO(user.getUserName(), user.getFullName(), user.getProfilePicture(), storyDTOs);
    }

    public List<UserStoriesDTO> getStoriesOfFollowedUsers(String userId) {
        // Step 1: Fetch all the Story entities of the followed users
        List<Story> stories = storyRepository.getStoriesOfFollowedUsers(userId);

        // Step 2: Group the stories by User
        Map<User, List<Story>> storiesGroupedByUser = stories.stream().collect(Collectors.groupingBy(Story::getUser));

        // Step 3: Create a list of UserStoriesDTO based on the grouped data
        List<UserStoriesDTO> userStoriesDTOList = storiesGroupedByUser.entrySet().stream()
                .map(entry -> {
                    User user = entry.getKey();
                    List<Story> userStories = entry.getValue();

                    // Step 4: Map Story entities to StoryDTO
                    List<StoryDTO> storyDTOs = userStories.stream()
                            .map(story -> new StoryDTO(
                                    story.getStoryId(),
                                    story.getStoryImage(),
                                    story.getCreationDate()
                            ))
                            .collect(Collectors.toList());

                    // Step 5: Create and return UserStoriesDTO for each user
                    return new UserStoriesDTO(
                            user.getUserName(),
                            user.getFullName(),
                            user.getProfilePicture(),
                            storyDTOs
                    );
                })
                .collect(Collectors.toList());

        // Step 6: Return the list of UserStoriesDTO
        return userStoriesDTOList;
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
