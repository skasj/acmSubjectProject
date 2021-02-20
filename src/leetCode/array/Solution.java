package leetCode.array;

/**
 * date: 2021/2/20 10:37
 * @author dongyu.ye
 * @description:
 * @since 3.1.0
 */
public class Solution {

    /**
     * @see <a href="https://leetcode-cn.com/problems/degree-of-an-array/">697. 数组的度</a>
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        // 1.找到频数最大的数，可能有多个
        int maxDegree = 0;
        int[] degreeList = new int[50001];
        int[] lPosList = new int[50001];
        int[] rPosList = new int[50001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (degreeList[num]==0){
                lPosList[num]=i;
            }
            degreeList[num]++;
            if (degreeList[num]>maxDegree){
                maxDegree=degreeList[num];
            }
            rPosList[num]=i;
        }
        int minDistance = 50002;
        for (int i = 0; i < degreeList.length; i++) {
            if (degreeList[i] == maxDegree){
                int distance = rPosList[i] - lPosList[i];
                if (distance<minDistance){
                    minDistance = distance;
                }
            }
        }
        return minDistance +1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
