package lintCode;

import java.util.HashMap;
import java.util.Map;

public class caipaio {

    public static void main(String[] args) {
        int[][] nums = {
                {3, 7, 18, 25, 30, 2, 7},
                {17, 25, 26, 32, 34, 4, 7},
                {7, 11, 12, 16, 33, 5, 7},
                {1, 2, 7, 33, 35, 6, 10},
                {3, 4, 7, 11, 30, 8, 9},
                {9, 12, 19, 22, 33, 7, 8},
                {10, 11, 26, 33, 34, 1, 6},
                {5, 9, 19, 22, 32, 3, 5},
                {2, 5, 20, 28, 31, 2, 11},
                {4, 22, 23, 24, 32, 6, 12},
                {3, 4, 26, 29, 33, 6, 7},
                {2, 10, 20, 21, 35, 1, 12},
                {3, 7, 8, 25, 27, 3, 5},
                {1, 5, 7, 8, 11, 6, 10},
                {4, 6, 7, 20, 29, 2, 4},
                {3, 5, 12, 13, 26, 7, 12},
                {3, 16, 20, 26, 29, 3, 9},
                {4, 5, 19, 25, 26, 1, 11},
                {5, 6, 7, 14, 17, 10, 11},
                {3, 12, 24, 27, 34, 1, 12},
                {3, 5, 6, 13, 18, 10, 12},
                {5, 6, 14, 27, 29, 6, 10},
                {1, 13, 20, 21, 26, 4, 10},
                {10, 13, 18, 23, 30, 6, 12},
                {20, 21, 25, 34, 35, 3, 12},
                {4, 7, 8, 11, 16, 9, 11},
                {5, 9, 16, 18, 30, 4, 7},
                {5, 8, 9, 14, 34, 2, 5},
                {7, 17, 26, 27, 30, 6, 12},
                {3, 13, 15, 26, 30, 5, 12}
        };
        HashMap<String, Integer> map = new HashMap<>();
        int[] tag1, tag2;
        String key;
        for (int[] ints : nums) {
            key = "";
            tag1 = new int[5];
            tag2 = new int[2];
            for (int i = 0; i < 5; i++) {
                tag1[(ints[i] - 1) / 7]++;
            }
            for (int i = 5; i < 7; i++) {
                tag2[(ints[i] - 1) / 6]++;
            }
            for (int tag : tag1) {
                key = key + tag + " ";
            }
            for (int tag : tag2) {
                key = key + tag + " ";
            }
            map.put(key, null == map.get(key) ? 1 : (map.get(key) + 1));
        }
        System.out.println("1 8 15 22 29 1 7");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double  rate = (entry.getValue()/ nums.length);
            System.out.println(entry.getKey() + " " +  entry.getValue() +" " + rate);
        }
    }
}
