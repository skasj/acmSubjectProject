package leetCode.dynamicProgramming;


import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMaxFormSolution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] bp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = analysisString(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    bp[i][j] = Math.max(1 + bp[i - count[0]][j - count[1]], bp[i][j]);
                }
            }
        }
        return bp[m][n];
    }

    private int[] analysisString(String str) {
        char[] chars = str.toCharArray();
        int[] result = new int[2];
        for (char c : chars) {
            result[c - '0']++;
        }
        return result;
    }

    /**
     * 由贪心法则演进过来，而不是动态规划，这样比较好理解一点
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tail = new int[nums.length];
        int res = 1;
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[res - 1]) {
                tail[res] = nums[i];
                res++;
            } else {
                int pre = Integer.MIN_VALUE;
                // 这里可以用二分法优化
                for (int j = 0; j < res; j++) {
                    if (nums[i] > pre && nums[i] < tail[j]) {
                        tail[j] = nums[i];
                        break;
                    } else {
                        pre = tail[j];
                    }
                }
            }
        }
        return res;
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1) {
            return 1;
        }
        int preSide = 0;
        int length = 1;
        int res = length;
        for (int i = 1; i < A.length; i++) {
            int nowSide = Integer.compare(A[i - 1], A[i]);
            if (preSide * nowSide == -1) {
                length++;
            } else if (nowSide != 0) {
                length = 2;
            } else {
                length = 1;
            }
            res = Math.max(res, length);
            preSide = nowSide;
        }
        return res;
    }

    /**
     * 统计不同回文子序列
     * bp[c][i][j]
     * i 代表原有序列的左节点
     * j 代表原有序列的右节点
     *
     * @param S
     * @return
     */
    public int countPalindromicSubsequences(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        int mod = 1000000007;
        int[][][] bp = new int[4][n][n];
        for (int j = 0; j < n; ++j) {
            for (int i = j; i >= 0; i--) {
                for (int k = 0; k < 4; k++) {
                    int c = 'a' + k;
                    if (i == j) {
                        bp[k][i][j] = chars[i] == c ? 1 : 0;
                    } else {
                        if (c != chars[i]) {
                            bp[k][i][j] = bp[k][i + 1][j];
                        } else if (c != chars[j]) {
                            bp[k][i][j] = bp[k][i][j - 1];
                        } else {
                            bp[k][i][j] = 2;
                            if (j != i + 1) {
                                for (int m = 0; m < 4; m++) {
                                    bp[k][i][j] += bp[m][i + 1][j - 1];
                                    bp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int m = 0; m < 4; m++) {
            res += bp[m][0][n - 1];
            res %= mod;
        }
        return res;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] bp = new boolean[m+1][n+1];
        bp[0][0]=true;
        for (int i=0;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (p.charAt(j-1) == '*'){
                    bp[i][j] = bp[i][j-2];
                    if (match(s,p,i,j-1)){
                        bp[i][j] = bp[i][j] || bp[i-1][j];
                    }
                } else {
                    if (match(s,p,i,j)){
                        bp[i][j] = bp[i-1][j-1];
                    }
                }
            }
        }
        return bp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i==0){
            return false;
        }
        if (p.charAt(j-1)=='.'){
            return true;
        }
        return p.charAt(j - 1) == s.charAt(i-1);
    }

    /*
     1458. 两个子序列的最大点积
     1. 数组长度不同
     2. 两个子序列长度相同，子序列元素顺序不能改变
     3. dp[i][j]代表nums1[0,i]与nums[0,j]的最大点积
     4. dp[i][j]=
          有4种情况：
          a.不包含i dp[i-1][j]
          b.不包含j dp[i][j-1]
          c.只包含i和j nums1[i]*  nums2[j]
          d.包含i和j dp[i-1][j-1]+ nums1[i]*  nums2[j]
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0]*nums2[0];
        IntStream.range(1,nums2.length).forEach(i-> dp[0][i] = Math.max(dp[0][i-1], nums2[i]*nums1[0]));
        IntStream.range(1,nums1.length).forEach(i-> dp[i][0] = Math.max(dp[i-1][0], nums2[0]*nums1[i]));
        for (int i = 1;i<nums1.length;++i){
            for (int j=1;j<nums2.length;++j){
                int mul =nums1[i]*  nums2[j];
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = Math.max(dp[i-1][j-1] + mul,dp[i][j]);
                dp[i][j] = Math.max(mul,dp[i][j]);
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}
