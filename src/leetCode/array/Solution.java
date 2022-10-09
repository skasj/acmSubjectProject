package leetCode.array;

import java.util.*;

/**
 * date: 2021/2/20 10:37
 * @author dongyu.ye
 * @description:
 * @since 3.1.0
 */
public class Solution {

    /**
     * @param nums
     * @return
     * @see <a href="https://leetcode-cn.com/problems/degree-of-an-array/">697. 数组的度</a>
     */
    public int findShortestSubArray(int[] nums) {
        // 1.找到频数最大的数，可能有多个
        int maxDegree = 0;
        int[] degreeList = new int[50001];
        int[] lPosList = new int[50001];
        int[] rPosList = new int[50001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (degreeList[num] == 0) {
                lPosList[num] = i;
            }
            degreeList[num]++;
            if (degreeList[num] > maxDegree) {
                maxDegree = degreeList[num];
            }
            rPosList[num] = i;
        }
        int minDistance = 50002;
        for (int i = 0; i < degreeList.length; i++) {
            if (degreeList[i] == maxDegree) {
                int distance = rPosList[i] - lPosList[i];
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance + 1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] map = new int[numCourses][numCourses];
        int[] stack = new int[numCourses];
        int[] tag = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (tag[i] == 1) {
                continue;
            }
            if (!dfs(i, stack, map, tag)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int num, int[] stack, int[][] map, int[] tag) {
        if (stack[num] == 1) {
            return false;
        }
        stack[num] = 1;
        for (int j = 0; j < map[0].length; j++) {
            if (map[num][j] == 0) {
                continue;
            }
            if (tag[j] == 1) {
                continue;
            }
            if (!dfs(j, stack, map, tag)) {
                return false;
            }
        }
        stack[num] = 0;
        tag[num] = 1;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(2);
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.push(5);
        System.out.println(solution.popAtStack(0));
        solution.push(20);
        solution.push(21);
        System.out.println(solution.popAtStack(0));
        System.out.println(solution.popAtStack(2));
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    int[][] context;
    int[] idx;
    int capacity;
    int tailIndex;

    public Solution(int capacity) {
        context = new int[(200000 / capacity) + 1][capacity];
        this.capacity = capacity;
        idx = new int[(200000 / capacity) + 1];
        tailIndex = 0;
    }

    public void push(int val) {
        int i = 0;
        for (; i <= tailIndex+1; i++) {
            if (idx[i] != capacity) {
                context[i][idx[i]++] = val;
                break;
            }
        }
        if (i - 1 == tailIndex) {
            tailIndex = i;
        }
    }

    public int pop() {
        if (idx[tailIndex] == 0) {
            return -1;
        }
        int res = context[tailIndex][ --idx[tailIndex]];
        while (idx[tailIndex] == 0 && tailIndex != 0) {
            tailIndex--;
        }
        return res;
    }

    public int popAtStack(int index) {
        if (index >= context.length) {
            return -1;
        }
        if (index == tailIndex) {
            return pop();
        }
        if (idx[index] == 0) {
            return -1;
        } else {
            return context[index][--idx[index]];
        }
    }
}
