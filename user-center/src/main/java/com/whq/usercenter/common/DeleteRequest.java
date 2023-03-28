package com.whq.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: whq
 * @description: 通用的删除请求
 * @time: 2023/2/13 21:38
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
}
