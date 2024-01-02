package com.example.oa.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class NewUser implements Serializable {
    
    private String name;

    private Integer age;

    private String phoneNumber;

}
