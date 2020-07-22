package leetCode.dynamicProgramming;

public class RemoveBoxesSolution {

    int[][][] dp;
    int[] boxes;

    /**
     * 官方思路：
     * 用的是分治与回归
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        this.boxes = boxes;
        dp = new int[length][length][length];
        return calculationPoints(0,length-1,0);
    }

    private int calculationPoints(int l,int r, int k){
        if (l>r){
            return 0;
        }
        if (dp[l][r][k]!=0) return dp[l][r][k];
        while (r>1 && boxes[r]==boxes[r-1]){
            r--;
            k++;
        }
        dp[l][r][k]=calculationPoints(l,r-1,0) + (k+1)*(k+1);
        for (int i=l ;i <r; i++){
            if (boxes[i] == boxes[r]){
                dp[l][r][k]=Math.max(dp[l][r][k],calculationPoints(l,i,k+1)+calculationPoints(i+1,r-1,0));
            }
        }
        return dp[l][r][k];
    }

    public static void main(String[] args) {
        RemoveBoxesSolution solution = new RemoveBoxesSolution();
        int i = solution.removeBoxes(new int[]{5,8,3,8,4,8,5,7,4,2});
        System.out.println(i);
//        [5,8,3,8,4,8,5,7,4,2]  3
//        [5,8, ,8,4,8,5, ,4, ]  1
//        [5,8, ,8, ,8,5, ,4, ]  9
//        [5, , , , , ,5, ,4, ]  4
//        [ , , , , , , , ,4, ]  1

    }
}
