package com.example.oa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "oa_user")
@Data
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

}
