package com.yh.shenji;

import com.google.common.collect.Lists;
import com.yh.shenji.annotation.Main;
import com.yh.shenji.annotation.method.MethodProxyFactory;
import net.sf.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demo test
 *
 * @author YangDongYu
 * @date 2019/11/8 16:18
 */

public class test {
    public static void main(String[] args) {
        exce();
//        Main main = MethodProxyFactory.getProxyInstance(new Main());
//        main.test();
//        main.test("1111");
    }

    public static void execImpl() {
        exce();
    }

    public static void exce() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 3, 6, 5, 8, 6, 98, 456, 46, 45, 4654, 456, 4654873);
        List<Integer> collect = integers.parallelStream().filter(o -> o < 5).collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
