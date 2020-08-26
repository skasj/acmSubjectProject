package leetCode.exam;

public class StraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2){
            return true;
        }
        int[] a= coordinates[0];
        int[] b= coordinates[1];
        if (a[1]==b[1]){
            for(int[] coordinate: coordinates){
                if(coordinate[1]!= a[1]){
                    return false;
                }
            }
            return true;
        }
        double k =((double) (b[0]-a[0]))/(b[1]-a[1]);
        for(int i=2;i<coordinates.length;i++){
            int[] coordinate= coordinates[i];
            if(k!=((coordinate[0]-a[0])/(coordinate[1]-a[1]))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StraightLine straightLine = new StraightLine();
        System.out.println(straightLine.checkStraightLine(new int[][]{{1,-8},{2,-3},{1,2}}));
    }
}
