package leetCode.exam;

import java.util.Scanner;

public class SimpleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            analyze(scanner);
        }
    }

    private static void analyze(Scanner scanner) {
        int[] ints = new int[1001];
        int num = scanner.nextInt();
        while (num-->0){
            ints[scanner.nextInt()]=1;
        }
        for (int i=0;i<1001;i++){
            if (1==ints[i]){
                System.out.println(i);
            }
        }
    }
}
