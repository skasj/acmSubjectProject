/*
 * File Name:leetCode.multithreading.ZeroEvenOddMain is created on 2022/10/84:26 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.multithreading;

import java.util.function.IntConsumer;

/**
 * @author ydy
 * @Description:
 * @date: 2022/10/8 4:26 下午
 * @since JDK 1.8
 */
public class ZeroEvenOddMain {

    public static void main(String[] args) {
        final ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(51);
        final Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(new PrintInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(new PrintInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(new PrintInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static class PrintInt implements IntConsumer {

        @Override
        public void accept(int value) {
            System.out.print(value);
        }
    }
}