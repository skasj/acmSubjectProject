package lintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Permute {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        int[] ints = new int[size];
        for (int i=0;i<size;i++){
            ints[i] = scanner.nextInt();
        }
        System.out.println(new Permute().permute(ints));
    }

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     *//*
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutions = new ArrayList<>();

        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        do {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            int next = -1;
            for (int i=last+1;i<n;i++){
                if (!stack.contains(i)){
                    next= i;
                    break;
                }
            }

            if (next == -1){
                continue;
            }
            stack.add(next);


        }while (stack.size()!=0);
    }*/

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutations
                = new ArrayList<List<Integer>>();
        if (nums == null) {

            return permutations;
        }

        if (nums.length == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }

        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();

        stack.add(-1);
        int j =0;
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            ++j;
            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }

            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }

            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums[stack.get(i)]);
            }
            permutations.add(permutation);
        }
        System.out.println(j);
        return permutations;
    }
}
