package com.jsp.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseStructure<T> {

    private int statusCode;
    private String message;
    private T data;

}
