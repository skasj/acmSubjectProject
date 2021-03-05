package leetCode.dynamicProgramming;

/**
 * date: 2021/3/4 16:08
 * @author dongyu.ye
 * @description:
 * @since 3.1.0
 */
public class NumMatrix {

    final int[][] tempNumMatrix;

    public NumMatrix(int[][] matrix) {
        if (null == matrix || matrix.length==0){
            tempNumMatrix = new int[0][0];
            return;
        }
        tempNumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int temp = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                temp += matrix[i][j];
                if (i == 0) {
                    tempNumMatrix[i][j] = temp;
                } else {
                    tempNumMatrix[i][j] = tempNumMatrix[i - 1][j] + temp;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = 0;
        if (row1 != 0 && col1 != 0) {
            up = tempNumMatrix[row1 - 1][col1 - 1];
        }
        int left = 0;
        if (col1 != 0) {
            left = tempNumMatrix[row2][col1 - 1];
        }
        int right = 0;
        if (row1 != 0) {
            right = tempNumMatrix[row1 - 1][col2];
        }
        return tempNumMatrix[row2][col2] - left - right + up;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        });
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
}
