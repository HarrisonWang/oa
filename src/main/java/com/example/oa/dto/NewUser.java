package com.example.oa.dto;

import com.example.oa.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class NewUser implements Serializable {
    
    private String name;

    private Integer age;

    private String phoneNumber;

    public User convertToUser() {
        return new NewUserConvert()
                .convert(this);
    }

    private static class NewUserConvert implements DtoConvert<NewUser, User> {

        @Override
        public User convert(NewUser newUser) {
            User user = new User();
            BeanUtils.copyProperties(newUser, user);
            return user;
        }

    }

}
