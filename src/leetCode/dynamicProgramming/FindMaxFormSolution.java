package leetCode.dynamicProgramming;


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

    /**
     * 由贪心法则演进过来，而不是动态规划，这样比较好理解一点
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length==0){
            return 0;
        }
        int[] tail = new int[nums.length];
        int res = 1;
        tail[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]>tail[res-1]){
                tail[res]=nums[i];
                res++;
            } else {
                int pre = Integer.MIN_VALUE;
                // 这里可以用二分法优化
                for (int j=0;j<res;j++){
                    if (nums[i]>pre&&nums[i]<tail[j]){
                        tail[j]=nums[i];
                        break;
                    } else {
                        pre=tail[j];
                    }
                }
            }
        }
        return res;
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length==1){
            return 1;
        }
        int preSide = 0;
        int length = 1;
        int res = length;
        for (int i = 1;i<A.length;i++){
            int nowSide = Integer.compare(A[i-1],A[i]);
            if (preSide * nowSide == -1){
                length++;
            } else if (nowSide != 0){
                length = 2;
            } else {
                length = 1;
            }
            res=Math.max(res,length);
            preSide = nowSide;
        }
        return res;
    }

    /**
     * 统计不同回文子序列
     * bp[c][i][j]
     * i 代表原有序列的左节点
     * j 代表原有序列的右节点
     * @param S
     * @return
     */
    public int countPalindromicSubsequences(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        int mod = 1000000007;
        int[][][] bp =new int[4][n][n];
        for (int j=0;j< n;++j){
            for (int i=j;i>=0; i--) {
                for (int k=0;k<4;k++){
                    int c = 'a' + k;
                    if ( i == j){
                        bp[k][i][j] = chars[i] == c ? 1 : 0;
                    } else {
                        if (c != chars[i]){
                            bp[k][i][j] = bp[k][i+1][j];
                        } else if (c!=chars[j]) {
                            bp[k][i][j] = bp[k][i][j-1];
                        } else {
                            bp[k][i][j] = 2;
                            if (j != i+1){
                                for (int m=0;m<4;m++){
                                    bp[k][i][j] += bp[m][i+1][j-1];
                                    bp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int m=0;m<4;m++){
            res += bp[m][0][n-1];
            res %= mod;
        }
        return res;
    }
}
