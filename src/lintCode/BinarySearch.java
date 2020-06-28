package lintCode;

public class BinarySearch {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int solution(int[] nums, int target) {
        // write your code here
        int startIndex = 0;
        int endIndex = nums.length-1;
        int mid;
        while (endIndex!=startIndex){
            mid = (startIndex + endIndex)/2;
            if (nums[mid]>=target){
                endIndex = mid;
            }else {
                startIndex = mid + 1;
            }
        }
        return nums[startIndex]==target?startIndex:-1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 10};
        System.out.println(binarySearch.solution(nums, 3));
    }
}
