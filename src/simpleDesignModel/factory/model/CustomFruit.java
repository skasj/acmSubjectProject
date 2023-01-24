/*
 * File Name:simpleDesignModel.factory.model.CustomFruit is created on 2023/1/249:47 上午 by ydy
 *
 * Copyright (c) 2023, shengdiudiu technology All Rights Reserved.
 *
 */
package simpleDesignModel.factory.model;

/**
 * @author ydy
 * @Description: 自定义水果
 * @date: 2023/1/24 9:47 上午
 * @since JDK 1.8
 */
public class CustomFruit implements Fruit{

    private String name;

    public CustomFruit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public CustomFruit name(String n){
        this.name = n;
        return this;
    }

    public static class CustomFruitBuilder{
        private CustomFruit customFruit = new CustomFruit("");

        public CustomFruitBuilder name(String n){
            customFruit.name = n;
            return this;
        }

        public CustomFruit build(){
            return customFruit;
        }
    }
}