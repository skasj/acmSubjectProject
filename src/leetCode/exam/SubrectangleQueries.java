package leetCode.exam;

public class SubrectangleQueries {

    private int[][] rectangle;
    private int row;
    private int col;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        row = rectangle.length;
        if (row!=0){
            col=rectangle[0].length;
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i=row1;i<=row2&& i<=row;i++){
            for (int j=col1;j<=col2&&j<=col;j++){
                rectangle[i][j]=newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
