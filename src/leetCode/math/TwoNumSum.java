/*
 * File Name:leetCode.math.TwoNumSum is created on 2022/12/11:52 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ydy
 * @Description:
 * @date: 2022/12/1 1:52 下午
 * @since JDK 1.8
 */
public class TwoNumSum {
    public static void main(String[] args) {
        TwoNumSum twoNumSum = new TwoNumSum();
        System.out.println(twoNumSum.twoSum(new int[] {3, 2, 4}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        Integer[] indexs = new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            indexs[i] = i;
        }
        Arrays.sort(indexs, Comparator.comparingInt(x -> nums[x]));
        int t=0;
        for (int i=0;i< nums.length;i++){
            t = findX(indexs, nums,i+1,nums.length-1,target- nums[i]);
            if (t != -1){
                if (indexs[i]>indexs[t]){
                    return new int[]{indexs[t],indexs[i]};
                } else {
                    return new int[]{indexs[i],indexs[t]};
                }
            }
        }
        return new int[]{0,0};
    }

    private int findX(Integer[] indexs, int[] nums, int s,int e,int t){
        if (s>e){
            return -1;
        }
        int mid = (s+e)/2;
        if (nums[indexs[mid]] == t) {
            return mid;
        } else if (nums[indexs[mid]] > t) {
            return findX(indexs,nums, s, mid -1, t);
        } else {
            return findX(indexs, nums, mid +1, e, t);
        }
    }
}