package aLevel1to100;

import java.util.Scanner;

public class AAddBProbleam2 {

    public static void  main(){
        double[] d = new double[1001];
        Scanner scanner = new Scanner(System.in);
        int a,temp ;
        a = scanner.nextInt();
        for(int i=0; i<a;i++){
            temp = scanner.nextInt();
            d[temp] += scanner.nextDouble();
        }
        a = scanner.nextInt();
        for(int i=0; i<a;i++){
            temp = scanner.nextInt();
            d[temp] += scanner.nextDouble();
        }
        StringBuilder sb = new StringBuilder();
        int count= 0;
        for(int i = 1000; i>=0; i--){
            if (d[i]!=0){
                sb.append(" ").append(i).append(" ").append(String.format("%.1f",d[i]));
                count++;
            }
        }
        sb.insert(0,count);
        System.out.println(sb.toString());
    }
}
