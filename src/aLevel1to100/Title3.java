package aLevel1to100;

import java.util.Arrays;
import java.util.Scanner;

public class Title3 {

    private static int[][] roads = new int[505][505];
    private static int[] cityWight = new int[505];
    private static boolean[] cityIn = new boolean[505];
    private static int startCity,endCity,cityNum,roadsNum;
    private static int[] w = new int[505];
    private static int[] p = new int[505];
    private static int[] d = new int[505];

    public static void main(String[] args) {
        for (int i = 0; i<505;i++){
            Arrays.fill(roads[i],Integer.MAX_VALUE);
        }
        Arrays.fill(d,Integer.MAX_VALUE);


        Scanner scanner = new Scanner(System.in);
        cityNum = scanner.nextInt();
        roadsNum = scanner.nextInt();
        startCity = scanner.nextInt();
        endCity = scanner.nextInt();
        for (int i = 0; i < cityNum; i++) {
            cityWight[i] = scanner.nextInt();
        }
        for (int i = 0; i < roadsNum; i++) {
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            roads[j][k] = roads[k][j] =l;
        }

        d[startCity] = 0;
        w[startCity] = cityWight[startCity];
        p[startCity] = 1;
        for (int i = 0; i < cityNum; i++) {
            int min = Integer.MAX_VALUE;
            int minNo = -1;
            for (int j=0; j< cityNum; j++){
                if (!cityIn[j] && d[j] < min){
                    minNo = j;
                    min = d[j];
                }
            }
            if (minNo == -1){
                break;
            }
            cityIn[minNo]=true;
            for (int j=0;j<cityNum;j++){
                if (!cityIn[j] && roads[minNo][j] != Integer.MAX_VALUE){
                    if (roads[minNo][j]+d[minNo]<d[j]){
                        d[j] = roads[minNo][j]+d[minNo];
                        p[j] = p[minNo];
                        w[j] = w[minNo] + cityWight[j];
                    } else if (roads[minNo][j]+d[minNo]==d[j]){
                        p[j] += p[minNo];
                        if ( w[minNo] + cityWight[j] > w[j]){
                            w[j] = w[minNo] + cityWight[j];
                        }
                    }
                }
            }
//            System.out.println("-----------------------");
//            System.out.println(Arrays.toString(d));
//            System.out.println(Arrays.toString(p));
//            System.out.println(Arrays.toString(w));
        }
        System.out.printf("%d %d",p[endCity],w[endCity]);
    }
}
