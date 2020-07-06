package leetCode.array;

public class FindMinFibonacciNumbersSolution {
    public int findMinFibonacciNumbers(int k) {
        int bits = 1;
        int[] nums = new int[100];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2;nums[bits] >= k;i++){
            nums[i] = nums[i-1] + nums[i-2];
            bits = i;
        }
        int count = 0;
        while(k!= 0){
            while(nums[bits]>k){
                bits--;
            }
            k = k - nums[bits];
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        FindMinFibonacciNumbersSolution solution = new FindMinFibonacciNumbersSolution();
        System.out.println(solution.findMinFibonacciNumbers(7));
    }
}
