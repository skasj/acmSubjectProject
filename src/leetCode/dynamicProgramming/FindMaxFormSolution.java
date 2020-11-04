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
}
