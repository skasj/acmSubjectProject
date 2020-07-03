package leetCode.array;

public class HeightCheckerSolution {
    /**
     * 解题思路:
     * 高度的范围值被限定在1-100之间，最终的排序其实是固定的，通过O(n)复杂度就可以推算出某个位置的数字应该是几
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] counter = new int[101];
        for (int height:heights){
            ++counter[height];
        }
        int count =0;
        int hindex = 1;
        for (int i=0;i<heights.length;i++){
            while (counter[hindex]==0){
                hindex++;
            }
            if (hindex == heights[i]){
                count++;
            }
            --counter[hindex];
        }
        return count;
    }

    public static void main(String[] args) {
        HeightCheckerSolution heightCheckerSolution = new HeightCheckerSolution();
        System.out.println(heightCheckerSolution.heightChecker(new int[]{5, 1, 2, 3, 4}));
    }
}
