package com.example.oa.dto;

import com.example.oa.entity.User;
import com.example.oa.vo.UserVo;
import org.springframework.beans.BeanUtils;

public class UserConvert implements DtoConvert<User, UserVo>{

    @Override
    public UserVo convert(User user) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

}
