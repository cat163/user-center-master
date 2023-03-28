package com.whq.usercenter.common;

/**
 * @author: whq
 * @description: 返回工具类(返回结果统一封装)
 * @time: 2022/12/28 19:53
 */
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<>(0,data,"ok");
    }

    /**
     * 失败
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode){
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse error(ErrorCode errorCode, String message, String description){
        return new BaseResponse(errorCode.getCode(),null,message,description);
    }

    public static BaseResponse error(int code, String message, String description){
        return new BaseResponse(code,null,message,description);
    }
}
