package leetCode.array;

/**
 * 给定一个数组，如果是非递减数组，或者改变一个数字能变成非递减数组，那就返回true
 */
public class NonDecreasingArraySolution {

    /**
     * 思路：拆分法
     * 非递减数组的子集必定也是非递减数组，拆剪成最小问题只有三种情况：
     * 1. 两个数字：2 -> 1 改变迁移个数字，也就是数字2变成1
     * 2. 三个数字: 1 -> 3 -> 2 ,2>=1:改变前一个数字，也就是数字3，变成数字2
     * 3. 三个数字: 2 -> 3 -> 1 ,1<2:改变当前数字也就是数字1，变成数字3
     * <p>
     * 1,2两种情况可以归为1类
     * 3单独一类
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (++count > 1){
                    return false;
                }
                if (i == 1 || nums[i] >= nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArraySolution solution = new NonDecreasingArraySolution();
        System.out.println(solution.checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{2, 3, 3, 2, 4}));
        System.out.println(solution.checkPossibility(new int[]{3, 3, 2, 2}));
        System.out.println(solution.checkPossibility(new int[]{1, 2, 5, 3, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(solution.checkPossibility(new int[]{1, 2, 4, 5, 3}));
        System.out.println(solution.checkPossibility(new int[]{3, 4, 2, 3}));
        System.exit(0);
    }
}
