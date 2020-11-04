package leetCode.dynamicProgramming;

import java.util.Arrays;

public class FindMaxFormSolution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] bp = new int[m+1][n+1];
        for (String str:strs){
            int[] count = analysisString(str);
            for (int i=m;i>=count[0];i--){
                for (int j=n;j>=count[1];j--){
                    bp[i][j] = Math.max(1+bp[i-count[0]][j-count[1]],bp[i][j]);
                }
            }
        }
        return bp[m][n];
    }

    private int[] analysisString(String str){
        char[] chars = str.toCharArray();
        int[] result = new int[2];
        for (char c:chars){
            result[c-'0']++;
        }
        return result;
    }

    public int lengthOfLIS(int[] nums) {
        if (null==nums||0==nums.length){
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int index =0;index<nums.length;index++){
            for (int pre = 0;pre< index;pre++){
                if (nums[index]>nums[pre]){
                    dp[index]=Math.max(1+dp[pre],dp[index]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt() +1;
    }
}
