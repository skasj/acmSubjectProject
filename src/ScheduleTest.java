/*
 * File Name:PACKAGE_NAME.ScheduleTest is created on 2022/7/134:19 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ydy
 * @Description: 定时器测试
 * @date: 2022/7/13 4:19 下午
 * @since JDK 1.8
 */
public class ScheduleTest {

    public static final AtomicInteger at = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            at.addAndGet(1);
            System.out.println("-------"+at.get());
            if (at.get() == 3){
                System.out.println("error");
                throw new RuntimeException();
            }
        }, 5L,2L, TimeUnit.SECONDS);
        while (true){
            Thread.sleep(2000L);
            System.out.println(System.currentTimeMillis());
        }
    }

}