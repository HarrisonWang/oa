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
        User user = newUser.convertToUser();
        UserVo userVo = userService.createUser(user).convertToUserVo();
        return ResponseEntity.ok(userVo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVo> updateUser(@PathVariable Long id, @RequestBody UpdatedUser updatedUser) {
        User user = updatedUser.convertToUser().setId(id);
        UserVo userVo = userService.updateUser(user).convertToUserVo();
        return ResponseEntity.ok(userVo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> getUser(@PathVariable Long id) {
        UserVo userVo = userService.getUser(id).convertToUserVo();
        return ResponseEntity.ok(userVo);
    }
}
