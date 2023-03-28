package com.whq.usercenter.once;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * @author: whq
 * @description: 导入Excel
 * @time: 2023/1/4 13:58
 */
public class ReadExcel {

    public static void main(String[] args) {
        String fileName = "src/main/resources/testExcel.xlsx";
        readByListener(fileName);
        synchronousRead(fileName);
    }


    /**
     * 监听器读取
     * @param fileName 文件名称
     */
    public static void readByListener(String fileName){
        EasyExcel.read(fileName, UserTableInfo.class, new UserTableInfoListener()).sheet().doRead();
    }

    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
     * @param fileName 文件名称
     */
    public static void synchronousRead(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<UserTableInfo> totalDataList = EasyExcel.read(fileName).head(UserTableInfo.class).sheet().doReadSync();
        for (UserTableInfo userTableInfo : totalDataList) {
            System.out.println(userTableInfo);
        }
    }
}
