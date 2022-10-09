import java.util.*;

public class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        System.out.println(Arrays.toString(main.advantageCount(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11})));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        Integer[] index1 = new Integer[n];
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index1[i] = i;
            index2[i] = i;
        }
        Arrays.sort(index1,(i,j)-> nums1[i]-nums1[j]);
        Arrays.sort(index2,(i,j)-> nums2[i]-nums2[j]);
        int left = 0;
        int right = n-1;
        int[] ans = new int[n];
        for (int i=0; i< n;i++){
            if (nums1[index1[i]]>nums2[index2[left]]){
                ans[index2[left]] = nums1[index1[i]];
                left ++;
            } else {
                ans[index2[right]] = nums1[index1[i]];
                right--;
            }
        }
        return ans;
    }
}
