package leetCode.datastructure;

import java.util.Stack;

public class MaximalRectangleSolution {
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] buffer = new int[rows+1][cols];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='1'){
                    count++;
                } else {
                    count = 0;
                }
                buffer[i][j]=count;
            }
        }
        int max = 0;
        for (int i = 0; i < cols; i++) {
            int tmp = calMaxRecArea(buffer, i, rows + 1);
            max = Integer.max(tmp,max);
        }
        return max;
    }

    private int calMaxRecArea(int[][] matrix,int colN, int row){
        Stack<int[]> stack = new Stack<>();
        int max = -1;
        for (int i = 0; i < row; i++) {
            while (!stack.empty() && stack.peek()[0]> matrix[i][colN]){
                int[] last = stack.pop();
                int lastIndex = 0;
                if (!stack.empty()){
                    lastIndex = stack.peek()[1]+1;
                }
                max = Integer.max((i- lastIndex)*last[0],max);
            }
            stack.add(new int[]{matrix[i][colN],i});
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangleSolution solution = new MaximalRectangleSolution();
//        char[][] matrix1 = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        System.out.println(solution.maximalRectangle(matrix1));
//        char[][] matrix2 = new char[][]{};
//        System.out.println(solution.maximalRectangle(matrix2));
        char[][] matrix3 = new char[][]{{'0'}};
        System.out.println(solution.maximalRectangle(matrix3));
        char[][] matrix4 = new char[][]{{'1'}};
        System.out.println(solution.maximalRectangle(matrix4));
        char[][] matrix5 = new char[][]{{'0','0'}};
        System.out.println(solution.maximalRectangle(matrix5));
    }
}
