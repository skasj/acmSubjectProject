/*
 * File Name:leetCode.array.RandomLinkedArray is created on 2022/11/302:50 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.array;

import java.util.Random;

/**
 * @author ydy
 * @Description:
 * @date: 2022/11/30 2:50 下午
 * @since JDK 1.8
 */
public class RandomLinkedArray {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    Random random = new Random();

    int n =0;

    ListNode[] array;

    public RandomLinkedArray(ListNode head) {
        ListNode index= head;
        while (null!=index.next){
            index = index.next;
            n++;
        }
        array = new ListNode[n];
        index = head;
        for (int i = 0; i < n; i++) {
            array[i] = index;
            index = index.next;
        }
    }

    public int getRandom() {
        return array[Math.abs(random.nextInt())%n].val;
    }

}