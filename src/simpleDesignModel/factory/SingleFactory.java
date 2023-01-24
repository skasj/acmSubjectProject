/*
 * File Name:simpleDesignModel.factory.SingleFactory is created on 2023/1/249:44 上午 by ydy
 *
 * Copyright (c) 2023, shengdiudiu technology All Rights Reserved.
 *
 */
package simpleDesignModel.factory;

import simpleDesignModel.factory.model.Apple;
import simpleDesignModel.factory.model.Fruit;

/**
 * @author ydy
 * @Description: 单例工厂
 * @date: 2023/1/24 9:44 上午
 * @since JDK 1.8
 */
public class SingleFactory {

    private static volatile Apple apple = null;

    public static Fruit getApple(){
        if (null!=apple){
            return apple;
        }
        synchronized (SingleFactory.class){
            if (null!=apple){
                return apple;
            }
            apple = new Apple();
            return apple;
        }
    }
}