package com.whq.usercenter.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: whq
 * @description: 导入用户信息
 * @time: 2023/1/4 14:12
 */
@Data
public class UserTableInfo {

    /**
     * id
     */
    @ExcelProperty("账号ID")
    private Long id;

    /**
     * 账号
     */
    @ExcelProperty("账号名称")
    private String userAccount;

    /**
     * 用户昵称
     */
    @ExcelProperty("用户昵称")
    private String username;
}
