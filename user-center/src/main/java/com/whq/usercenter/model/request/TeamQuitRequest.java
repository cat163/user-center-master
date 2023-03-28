package com.whq.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: whq
 * @description:
 * @time: 2023/2/27 20:34
 */
@Data
public class TeamQuitRequest implements Serializable {

    /**
     * id
     */
    private Long teamId;

}
