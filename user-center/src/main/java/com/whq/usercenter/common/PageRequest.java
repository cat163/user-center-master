package com.whq.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: whq
 * @description: 通用分页请求参数
 * @time: 2023/2/13 21:38
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前第几页
     */
    protected int pageNum = 1;


}
