package com.example.oa.controller;

import com.example.oa.dto.*;
import com.example.oa.entity.User;
import com.example.oa.service.UserService;
import com.example.oa.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserVo> createUser(@RequestBody NewUser newUser) {
        User user = new NewUserConvert().convert(newUser);
        User result = userService.createUser(user);
        UserVo userVo = new UserConvert().convert(result);
        return ResponseEntity.ok(userVo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVo> updateUser(@PathVariable Long id, @RequestBody UpdatedUser updatedUser) {
        User user = new UpdatedUserConvert().convert(updatedUser)
                .setId(id);
        User result = userService.updateUser(user);
        UserVo userVo = new UserConvert().convert(result);
        return ResponseEntity.ok(userVo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> getUser(@PathVariable Long id) {
        User result = userService.getUser(id);
        UserVo userVo = new UserConvert().convert(result);
        return ResponseEntity.ok(userVo);
    }
}
