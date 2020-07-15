package leetCode.dynamicProgramming;

import java.util.Arrays;

public class Largest1BorderedSquareSolution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] left = new int[grid.length][grid[0].length];
        int[][] right = new int[grid.length][grid[0].length];
        int[][] up = new int[grid.length][grid[0].length];
        int[][] down = new int[grid.length][grid[0].length];
        int max = 0;
        // 1. 统计左侧长度
        for (int i =0;i<left.length;i++){
            left[i][0] = grid[i][0];
            for (int j = 1;j<left[0].length;j++){
                if (grid[i][j]==1){
                    left[i][j]=left[i][j-1]+1;
                }
            }
        }
        // 2. 统计右侧长度
        for (int i =0;i<right.length;i++){
            right[i][right[0].length-1] = grid[i][right[0].length-1];
            for (int j = right[0].length-2;j>-1;j--){
                if (grid[i][j]==1){
                    right[i][j]=right[i][j+1]+1;
                }
            }
        }
        // 3. 统计上方长度
        up[0] = Arrays.copyOf(grid[0],grid[0].length);
        for (int i =1;i<up.length;i++){
            for (int j = 0;j<up[0].length;j++){
                if (grid[i][j]==1){
                    up[i][j]=up[i-1][j]+1;
                }
            }
        }
        // 4. 统计上方长度
        down[grid.length-1] = Arrays.copyOf(grid[grid.length-1],grid[0].length);
        for (int i =down.length-2;i>-1;i--){
            for (int j = 0;j<down[0].length;j++){
                if (grid[i][j]==1){
                    down[i][j]=down[i+1][j]+1;
                }
            }
        }
        // 5. 统计正方形
        int tmp;
        for (int i =0;i<left.length;i++){
            for (int j = 0;j<left[0].length;j++){
                tmp = Math.min(right[i][j], down[i][j]);
                while (tmp !=0){
                    if (tmp<=left[i+tmp-1][j+tmp-1] && tmp<=up[i+tmp-1][j+tmp-1]){
                        max = Math.max(max,tmp);
                    }
                    tmp--;
                }
            }
        }
        sout(grid);
        sout(left);
        sout(right);
        sout(up);
        sout(down);

        return max*max;
    }

    public static void main(String[] args) {
        Largest1BorderedSquareSolution solution = new Largest1BorderedSquareSolution();
//        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
//        System.out.println(solution.largest1BorderedSquare(new int[][]{{0,0,0,1}}));
        System.out.println(solution.largest1BorderedSquare(new int[][]{{0,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1},{1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1},{1,0,1,0,0,1,1,1},{0,1,1,1,1,0,1,1}}));
    }

    private void sout(int[][] nums){
        System.out.println("------------");
        for (int[] num:nums){
            System.out.println(Arrays.toString(num));
        }
    }
}
