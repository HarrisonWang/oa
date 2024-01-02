package com.example.oa.controller;

import com.example.oa.dto.NewUser;
import com.example.oa.dto.UpdatedUser;
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
        User user = new User();
        user.setName(newUser.getName());
        user.setAge(newUser.getAge());
        user.setPhoneNumber(newUser.getPhoneNumber());

        User result = userService.createUser(user);

        UserVo userVo = new UserVo();
        userVo.setId(result.getId());
        userVo.setName(result.getName());
        userVo.setAge(result.getAge());
        userVo.setPhoneNumber(result.getPhoneNumber());

        return ResponseEntity.ok(userVo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVo> updateUser(@PathVariable Long id, @RequestBody UpdatedUser updatedUser) {
        User user = new User();
        user.setId(id);
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setPhoneNumber(updatedUser.getPhoneNumber());

        User result = userService.updateUser(user);

        UserVo userVo = new UserVo();
        userVo.setId(result.getId());
        userVo.setName(result.getName());
        userVo.setAge(result.getAge());
        userVo.setPhoneNumber(result.getPhoneNumber());

        return ResponseEntity.ok(userVo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> getUser(@PathVariable Long id) {
        User result = userService.getUser(id);

        UserVo userVo = new UserVo();
        userVo.setId(result.getId());
        userVo.setName(result.getName());
        userVo.setAge(result.getAge());
        userVo.setPhoneNumber(result.getPhoneNumber());

        return ResponseEntity.ok(userVo);
    }

}
