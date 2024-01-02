package com.example.oa.dto;

public interface DtoConvert<S, T> {

    T convert(S s);

}