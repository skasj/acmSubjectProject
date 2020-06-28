package leetCode.array;

public class NumOfSubarraysSolution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        threshold *= k;
        for (int i =0; i< k; i++){
            sum += arr[i];
        }
        if (sum >= threshold){
            count ++;
        }
        for (int m=0,n=k;n<arr.length;m++,n++){
            sum = sum -arr[m] + arr[n];
            if (sum >= threshold){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumOfSubarraysSolution solution = new NumOfSubarraysSolution();
        System.out.println(solution.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
    }
}
