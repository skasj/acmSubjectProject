/*
 * File Name:leetCode.map.LRUCache is created on 2022/12/28:18 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.map;

/**
 * @author ydy
 * @Description:
 * @date: 2022/12/2 8:18 下午
 * @since JDK 1.8
 */
public class LRUCache {
    int[] values = new int[10001];
    int[] counts= new int[10001];
    int[] capacitys=new int[20001];
    int capacity;
    int c=0;
    int head = 0;
    int tail = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        for (int i=0;i<10001;i++){
            this.values[i]=-1;
        }
        for (int i=0;i<20001;i++){
            this.capacitys[i]=-1;
        }
    }

    public int get(int key) {
        if (this.values[key] == -1){
            return -1;
        }
        capacitys[tail]=key;
        counts[key]++;
        tail ++;
        return values[key];
    }

    public void put(int key, int value) {
        if (values[key]!=-1){
            counts[key]++;
            values[key] = value;
            capacitys[tail] = key;
            tail++;
            return;
        }
        if (c == capacity){
            while(counts[capacitys[head]]>0){
                counts[capacitys[head]]--;
                if (counts[capacitys[head]]==0){
                    values[capacitys[head]] = -1;
                    c--;
                    head++;
                    break;
                } else {
                    head++;
                }
            }
        }
        c++;
        values[key] = value;
        capacitys[tail++] = key;
        counts[key]++;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }
}