package com.example.oa.entity;

import com.example.oa.dto.DtoConvert;
import com.example.oa.vo.UserVo;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "oa_user")
@Data
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 手机号 */
    private String phoneNumber;
    public UserVo convertToUserVo() {
        return new User.UserConvert()
                .convert(this);
    }

    private static class UserConvert implements DtoConvert<User, UserVo> {

        @Override
        public UserVo convert(User user) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            return userVo;
        }

    }
}
