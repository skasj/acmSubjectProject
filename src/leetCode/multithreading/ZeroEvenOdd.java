/*
 * File Name:leetCode.multithreading.ZeroEvenOdd is created on 2022/10/84:25 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.multithreading;

import java.util.function.IntConsumer;

/**
 * @author ydy
 * @Description:
 * @date: 2022/10/8 4:25 下午
 * @since JDK 1.8
 */
public class ZeroEvenOdd {
    private int n;
    private static volatile int lastIsZero = 0;
    private static volatile int lastIsEven = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (lastIsZero == 0) {
                printNumber.accept(0);
                if ((i & 1) == 0) {
                    lastIsEven = 1;
                } else {
                    lastIsEven = 0;
                }
                lastIsZero = 1;
                i++;
            }
            Thread.yield();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; ) {
            if (lastIsZero == 1 && lastIsEven == 0) {
                printNumber.accept(i);
                lastIsZero = 0;
                i += 2;
            }
            Thread.yield();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ) {
            if (lastIsZero == 1 && lastIsEven == 1) {
                printNumber.accept(i);
                lastIsZero = 0;
                i += 2;
            }
            Thread.yield();
        }
    }
}