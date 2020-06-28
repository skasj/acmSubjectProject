package lintCode;

import java.util.ArrayList;
import java.util.List;

public class StringContain {

    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (null == source) {
            return -1;
        } else if (null == target || target.length() == 0) {
            return 0;
        }
        List<Integer> kmpRule = findKMPRule(target);
        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            if (target.charAt(j) != source.charAt(i)) {
                if (j!=0){
                    i = i - j;
                }
                j=kmpRule.get(j);
            } else {
                j++;
            }
            if (j==target.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    private List<Integer> findKMPRule(String target) {
        List<Integer> integers = new ArrayList<>();
        if (null == target || target.length() == 0) {
            return integers;
        }
        integers.add(0);
        int endindex = 0;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) == target.charAt(endindex)) {
                integers.add(endindex);
                endindex++;
            } else {
                endindex = 0;
                integers.add(endindex);
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        StringContain stringContain = new StringContain();
        System.out.println(stringContain.findKMPRule("issip"));
        int i = stringContain.strStr("mississippi", "issip");
        System.out.println(i);
    }
}
