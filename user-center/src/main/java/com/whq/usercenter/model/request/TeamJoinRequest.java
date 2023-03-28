package com.whq.usercenter.model.request;

import lombok.Data;


/**
 * @author: whq
 * @description:
 * @time: 2023/2/22 15:35
 */
@Data
public class TeamJoinRequest {

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}
