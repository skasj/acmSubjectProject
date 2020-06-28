package aLevel1to100;

import java.util.Arrays;
import java.util.Scanner;

public class Radix {
    private static char[] na = {'0','1','2','3','4','5','6','7','8','9',
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
    'r','s','t','u','v','w','x','y','z'};

/*    public static String main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num = scanner,int source,int target
        Integer numInterger = transferNumToString(num,source);

    }*/

    private static Integer transferNumToString(String num,int source){
        if (null == num || num.length()<=0){
            return null;
        }
        char[] chars= num.toCharArray();
        int i = num.length();
        int sum = 0;
        while (i>0){
            i--;
            int temp;
            if (chars[i]>=na[10]){
                temp = chars[i] - na[10];
            } else {
                temp = chars[i] - na[0];
            }
            sum += temp*Math.pow(source,num.length()-i-1);
        }
        return sum;
    }

    /*private static Integer transferStringToNum(Integer num,int source){
        if (null == num || num.length()<=0){
            return null;
        }
        char[] chars= num.toCharArray();
        int i = num.length();
        int sum = 0;
        while (i>0){
            i--;
            int temp;
            if (chars[i]>=na[10]){
                temp = chars[i] - na[10];
            } else {
                temp = chars[i] - na[0];
            }
            sum += temp*Math.pow(source,num.length()-i-1);
        }
        return sum;
    }*/
}
