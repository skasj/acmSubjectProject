package aLevel1to100;

import java.util.Scanner;

public class MaximumSubsequenceSum {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int maxSum = Integer.MIN_VALUE,tempLeftIndex = 0;
        int leftIndex = 0,rightIndex = k-1;
        int temp = 0;
        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            num[i] = scanner.nextInt();
            temp += num[i];
            if (temp<0){
                temp = 0;
                tempLeftIndex = i+1;
            } else if (temp >maxSum){
                maxSum =temp;
                leftIndex = tempLeftIndex;
                rightIndex = i;
            }
        }
        if (maxSum < 0) {
            System.out.println(String.format("%d %d %d", 0, num[0], num[num.length - 1]));
            return;
        }
        System.out.println(String.format("%d %d %d", maxSum, num[leftIndex], num[rightIndex]));
    }
}
