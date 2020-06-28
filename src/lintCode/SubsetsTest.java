package lintCode;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(new SubsetsTest().subsets(ints));
    }

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        long l = System.currentTimeMillis();
        if (nums == null) {
            nums = new int[0];
        }
        HashSet<List<Integer>> stack = new HashSet<>();
        List<Integer> numList = Arrays.stream(nums).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
        stack.add(numList);
        List<Integer> ints;
        HashSet<List<Integer>> results = new HashSet<>();
        results.add(new ArrayList<>());
        results.add(numList);
        int j=0;
        while (stack.iterator().hasNext()) {
            j++;
            ints = stack.iterator().next();
            stack.remove(ints);
            if (ints == null || ints.size() == 0) {
                continue;
            } else if (ints.size() == 1) {
                results.add(ints);
                continue;
            }
            for (int i = 0; i < ints.size(); i++) {
                List<Integer> middle = ints.subList(i, i + 1);
                results.add(middle);
                List<Integer> left = new ArrayList<>(ints);
                left.remove(i);
                if (left.size()>1) {
                    stack.add(left);
                }
                results.add(left);
            }
        }
        System.out.println(results.size());
        System.out.println(j);
        System.out.println(System.currentTimeMillis()-l);
        return new ArrayList<>(results);
    }
}
