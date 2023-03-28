package com.whq.usercenter.service;

import com.whq.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: whq
 * @description: 算法工具类测试
 * @time: 2023/3/6 16:18
 */
public class AlgorithmUtilsTest {

    @Test
    void test() {
        String word1 = "你是他";
        String word2 = "你不是他";
        String word3 = "你是他不是他";
        int score1 = AlgorithmUtils.minDistance(word1, word2);
        int score2 = AlgorithmUtils.minDistance(word1, word3);
        System.out.println(score1);
        System.out.println(score2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("java", "大一", "男");
        List<String> tagList2 = Arrays.asList("java", "大二", "女");
        List<String> tagList3 = Arrays.asList("python", "大二", "女");

        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }
}
