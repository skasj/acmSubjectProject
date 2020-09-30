package leetCode.exam;

import java.util.Scanner;

public class WaterBottleClass {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int bn=0,dbn=0;
        int tbdn=0;
        while(scan.hasNext()){
            bn =scan.nextInt();
            if (bn == 0){
                break;
            }
            dbn=0;
            while(bn>2){
                tbdn = bn/3;
                dbn = dbn + tbdn;
                bn= tbdn + bn%3;
            }
            if (bn==2){
                dbn++;
            }
            System.out.println(dbn);
        }
    }
}
