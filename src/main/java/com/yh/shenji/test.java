package com.yh.shenji;

import com.yh.shenji.annotation.Main;
import com.yh.shenji.annotation.method.MethodProxyFactory;

/**
 * Demo test
 *
 * @author YangDongYu
 * @date 2019/11/8 16:18
 */

public class test {
    public static void main(String[] args) {
        Main main = MethodProxyFactory.getProxyInstance(new Main());
        main.test();
        main.test("1111");
    }

    public static void execImpl() {
        exce();
    }

    public static void exce() {
        System.out.println(1111);
        throw new RuntimeException("gan");
    }
}
