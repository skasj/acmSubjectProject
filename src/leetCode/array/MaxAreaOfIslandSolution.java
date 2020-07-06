package leetCode.array;

public class MaxAreaOfIslandSolution {
    private int[][] gridValue;
    private int rows;
    private int cols;

    public int maxAreaOfIsland(int[][] grid) {
        gridValue = grid;
        int max = 0;
        int area =0;
        rows = grid.length;
        cols = grid[0].length;
        for(int row =0 ; row < rows;row++){
            for(int col= 0; col < cols;col++){
                area = coutArea(row,col,0);
                if (area >max){
                    max = area;
                }
            }
        }
        return max;
    }

    private int coutArea(int row,int col,int sum){
        if (gridValue[row][col]== 0){
            return sum;
        } else {
            sum ++;
            gridValue[row][col] = 0;
            // 探索上下左右的地图
            if(row-1 > -1){
                sum = coutArea(row-1,col,sum);
            }
            if(row+1 < rows){
                sum = coutArea(row+1,col,sum);
            }
            if(col-1 > -1){
                sum = coutArea(row,col-1,sum);
            }
            if(col+1 < cols){
                sum = coutArea(row,col+1,sum);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIslandSolution solution = new MaxAreaOfIslandSolution();
        int[][] testData = new int[][]{{0,1},{1,1}};
        System.out.println(solution.maxAreaOfIsland(testData));
    }
}
