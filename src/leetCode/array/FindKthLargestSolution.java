/*
 * File Name:leetCode.array.FindKthLargestSolution is created on 2022/12/311:46 上午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.array;

import java.util.Arrays;

/**
 * @author ydy
 * @Description:
 * @date: 2022/12/3 11:46 上午
 * @since JDK 1.8
 */
public class FindKthLargestSolution {

    int[] stack;
    int index = 0;

    public int findKthLargest(int[] nums, int k) {
        stack = new int[nums.length];
        Arrays.fill(stack, -10001);
        for (int num:nums){
            put(num);
        }
        for (int i=1;i<k;i++){
            get();
        }
        return get();
    }

    private void put(int v){
        stack[index++] = v;
        on(index-1);
    }

    private int get(){
        int res = stack[0];
        stack[0] = stack[--index];
        stack[index] = -10001;
        up(0);
        return res;
    }

    private void on(int index){
        if (index ==0){
            return;
        }
        int t = (index-1)/2;
        int temp;
        if (stack[index] >stack[t]){
            temp = stack[index];
            stack[index] = stack[t];
            stack[t] = temp;
            on(t);
        }
    }

    private void up(int index){
        int t1 = index * 2+1;
        int t2 = index * 2+2;
        if (t1>=stack.length){
            return;
        }
        int t = t2;
        if (t2 >= stack.length || stack[t1] >= stack[t2]){
            t = t1;
        }
        int temp;
        if (stack[index] < stack[t]){
            temp = stack[index];
            stack[index] = stack[t];
            stack[t] = temp;
            up(t);
        }
    }

    public static void main(String[] args) {
        FindKthLargestSolution findKthLargestSolution = new FindKthLargestSolution();
//        System.out.println(findKthLargestSolution.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(findKthLargestSolution.findKthLargest(new int[] {-1,-1}, 2));

    }
}