package com.example.oa.service;

import com.example.oa.entity.User;
import com.example.oa.exception.ErrorCode;
import com.example.oa.exception.UserNotFoundException;
import com.example.oa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User updatedUser) {
        User user = getUser(updatedUser.getId());

        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND, "Getting '" + id + "' user failed!"));
    }

}
