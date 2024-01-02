package com.example.oa.dto;

import com.example.oa.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UpdatedUser {
    
    private String name;

    private Integer age;

    private String phoneNumber;

    public User convertToUser() {
        return new UpdatedUser.UpdatedUserConvert()
                .convert(this);
    }

    private static class UpdatedUserConvert implements DtoConvert<UpdatedUser, User> {

        @Override
        public User convert(UpdatedUser updatedUser) {
            User user = new User();
            BeanUtils.copyProperties(updatedUser, user);
            return user;
        }

    }

}
