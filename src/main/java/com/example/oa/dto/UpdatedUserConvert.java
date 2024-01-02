package com.example.oa.dto;

import com.example.oa.entity.User;
import org.springframework.beans.BeanUtils;

public class UpdatedUserConvert implements DtoConvert<UpdatedUser, User> {

    @Override
    public User convert(UpdatedUser newUser) {
        User user = new User();
        BeanUtils.copyProperties(newUser, user);
        return user;
    }

}
