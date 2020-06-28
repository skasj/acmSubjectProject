package leetCode.array;

import java.util.Arrays;

public class MovesToMakeZigzagSolution {
    /**
     * 递减元素使数组呈锯齿状, 思路:
     * 1. 分为先增后减，先减后增两种情况
     * 2. 要求当前节点大于上一节点时，操作上一节点
     * 3. 要求当前节点小于上一节点时，操作当前节点
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int increaseFirstOperateCount = 0;
        int decreaseFirstOperateCount = 0;

        return Math.min(increaseFirstOperateCount,decreaseFirstOperateCount);
    }

    public static void main(String[] args) {
        MovesToMakeZigzagSolution solution = new MovesToMakeZigzagSolution();
        System.out.println(solution.movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(solution.movesToMakeZigzag(new int[]{9,6,1,6,2}));
        System.out.println(solution.movesToMakeZigzag(new int[]{2,1,2}));
    }
}
