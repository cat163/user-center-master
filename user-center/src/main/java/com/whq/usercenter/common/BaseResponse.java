package com.whq.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: whq
 * @description: 通用返回类 => 返回类构造器 和 统一错误码 => 全局异常处理
 * @time: 2022/12/28 19:46
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code,data,message,"");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null , errorCode.getMessage(), errorCode.getDescription());
    }


}
