package com.whq.usercenter.once;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: whq
 * @description: 导入用户信息到数据库
 * @time: 2023/1/4 15:27
 */
public class WriteUserInfoToUserTable{

    public static void main(String[] args) {
        String fileName = "src/main/resources/testExcel.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<UserTableInfo> userTableInfoList = EasyExcel.read(fileName).head(UserTableInfo.class).sheet().doReadSync();
        System.out.println("总数：" + userTableInfoList.size());
        //item::getUserAccount === item -> item.getUserName() java8 Lambda特性 list变mapList
        Map<String, List<UserTableInfo>> listMap = userTableInfoList.stream()
                .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUserAccount()))
                .collect(Collectors.groupingBy(UserTableInfo::getUserAccount));
        System.out.println("listMap：" + listMap);
        System.out.println("listMap.keySet()：" + listMap.keySet());
        System.out.println( "listMap.entrySet()：" +listMap.entrySet());
        System.out.println("不重复账号数 = " + listMap.keySet().size());
        for (Map.Entry<String, List<UserTableInfo>> stringListEntry : listMap.entrySet()) {
            if (stringListEntry.getValue().size() > 1){
                System.out.println("username = " + stringListEntry.getKey());
            }
        }
    }

}
