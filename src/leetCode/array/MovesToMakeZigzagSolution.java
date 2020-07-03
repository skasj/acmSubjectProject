package leetCode.array;


public class MovesToMakeZigzagSolution {
    /**
     * 递减元素使数组呈锯齿状, 思路:
     * 1. 分为先增后减，先减后增两种情况
     * 2. 先增后减，奇数为峰底，必须同时小于左右两数
     * 3. 先减后增，偶数为峰底，必须同时小于左右两数
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int increaseFirstOperateCount = 0;
        int decreaseFirstOperateCount = 0;
        int leftNumber,rightNumber,tmpMin;
        for (int i = 1; i< nums.length; i= i +2){
            leftNumber = nums[i-1];
            rightNumber = i+1 < nums.length ? nums[i+1] : Integer.MAX_VALUE;
            tmpMin = Math.min(leftNumber, rightNumber);
            decreaseFirstOperateCount = tmpMin> nums[i] ? decreaseFirstOperateCount : (decreaseFirstOperateCount+nums[i]-tmpMin+1);
        }
        for (int i = 0; i< nums.length; i= i +2){
            leftNumber = i == 0 ? Integer.MAX_VALUE : nums[i-1];
            rightNumber = i+1 < nums.length ? nums[i+1] : Integer.MAX_VALUE;
            tmpMin = Math.min(leftNumber, rightNumber);
            increaseFirstOperateCount = tmpMin> nums[i] ? increaseFirstOperateCount : (increaseFirstOperateCount+nums[i]-tmpMin+1);
        }
        return Math.min(increaseFirstOperateCount,decreaseFirstOperateCount);
    }

    private int countOperateTime(int[] nums, boolean increaseFirst) {
        int operateTime = 0;
        boolean numIncreaseSide = increaseFirst;
        for (int i = 1;i<nums.length;i++){
            if (numIncreaseSide){
                while (nums[i]<=nums[i-1]){
                    nums[i-1]--;
                    operateTime++;
                }
            } else {
                while (nums[i]>=nums[i-1]){
                    nums[i]--;
                    operateTime++;
                }
            }
            numIncreaseSide = !numIncreaseSide;
        }
        return operateTime;
    }

    public static void main(String[] args) {
        MovesToMakeZigzagSolution solution = new MovesToMakeZigzagSolution();
        System.out.println(solution.movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(solution.movesToMakeZigzag(new int[]{9,6,1,6,2}));
        System.out.println(solution.movesToMakeZigzag(new int[]{2,1,2}));
        System.out.println(solution.movesToMakeZigzag(new int[]{2,7,10,9,8,9}));
    }
}
