package leetCode.array;

public class UniquePathsSolution {
    public int uniquePaths(int m, int n) {
        int tmp = m+n-2;
        double i =1,j=1;
        for(int k = 0;k< m-1;k++){
            i *= tmp;
            tmp--;
            j *= (k+1);
        }
        double v = i / j;
        return Double.valueOf(v+0.5).intValue();
    }

    public static void main(String[] args) {
        UniquePathsSolution uniquePathsSolution = new UniquePathsSolution();
        System.out.println(uniquePathsSolution.uniquePaths(23,12));
        System.out.println((18*17*16*15*14*13*12*11*10)/(9*8*7*6*5*4*3*2*1));
    }
}
