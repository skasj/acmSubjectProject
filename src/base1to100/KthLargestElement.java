package base1to100;


import java.util.Arrays;

public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n-k];
    }
}
