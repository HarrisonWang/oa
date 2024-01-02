package com.example.oa.dto;

import com.example.oa.entity.User;
import org.springframework.beans.BeanUtils;

public class NewUserConvert implements DtoConvert<NewUser, User> {

    @Override
    public User convert(NewUser newUser) {
        User user = new User();
        BeanUtils.copyProperties(newUser, user);
        return user;
    }

}
