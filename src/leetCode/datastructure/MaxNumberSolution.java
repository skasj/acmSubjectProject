package leetCode.datastructure;

import java.util.Arrays;

public class MaxNumberSolution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1[0]>nums2[0]){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int[] all = new int[length];
        int[] result = new int[k];
        int j=0;
        int t=0;
        for (int i = 0; i <length; i++) {
            if (j==m){
                all[i] = nums2[t++];
            } else if (t==n){
                all[i] = nums1[j++];
            } else if (nums1[j]>nums2[t]){
                all[i] = nums1[j++];
            } else {
                all[i] = nums2[t++];
            }
        }
        int delete = length - k;
        int index = 0;
        result[0] = all[0];
        for (int i = 1; i < all.length; i++) {
            if (delete==0){
                if (index+1==k){
                    break;
                }
                result[++index]=all[i];
            } else if (result[index]<all[i]){
                result[index] = all[i];
                delete--;
                while (index!=0 && delete>0 && result[index-1]<all[i]){
                    result[--index] = all[i];
                    delete--;
                }
            } else {
                if (index+1==k){
                    break;
                }
                result[++index] = all[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxNumberSolution maxNumberSolution = new MaxNumberSolution();
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 2, 8, 3}, 5)));
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{8,9}, new int[]{3, 9}, 3)));
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{3,9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(maxNumberSolution.maxNumber(new int[]{2,2,0,6,8,9,6}, new int[]{5,2,4,5,3,6,2}, 7)));
    }
}
