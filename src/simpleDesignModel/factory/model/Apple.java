/*
 * File Name:simpleDesignModel.factory.model.Apple is created on 2023/1/249:46 上午 by ydy
 *
 * Copyright (c) 2023, shengdiudiu technology All Rights Reserved.
 *
 */
package simpleDesignModel.factory.model;

/**
 * @author ydy
 * @Description:
 * @date: 2023/1/24 9:46 上午
 * @since JDK 1.8
 */
public class Apple implements Fruit {

    private String name = "Apple";

    @Override
    public String getName() {
        return name;
    }


}