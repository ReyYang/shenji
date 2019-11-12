package com.yh.shenji.annotation;

import com.yh.shenji.annotation.method.CalculationMethodTime;
import com.yh.shenji.annotation.method.EnableCalculationMethodTime;

/**
 * Demo Main
 *
 * @author YangDongYu
 * @date 2019/11/9 11:58
 */
@EnableCalculationMethodTime
public class Main {

    @CalculationMethodTime
    public void test(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----->");
    }

    public void  test(String s) {
        System.out.println("----->" + s);
    }

}
