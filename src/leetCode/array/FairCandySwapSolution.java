package leetCode.array;

import java.util.Arrays;

public class FairCandySwapSolution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0,sumB =0;
        for (int n :A){
            sumA += n;
        }
        for (int n :B){
            sumB += n;
        }
        int disparity = (sumA-sumB)/2;
        for (int n:A){
            for (int m:B){
                if (n == m + disparity){
                    return new int[]{n,m};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FairCandySwapSolution solution = new FairCandySwapSolution();
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1,1}, new int[]{2,2})));
    }
}
