package base1to100;

import java.util.Scanner;
import java.util.Stack;

public class parentheses_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Character> stack = new Stack<>();
        String s ;
        s = scanner.nextLine();
        int flag = 0;
        while (n>0){
            s = scanner.nextLine();
            s.trim();
            for(int i=0;i<s.length();i++){
                if (flag==1) {
                    break;
                }
                switch (s.charAt(i)) {
                    case '(':
                        stack.push('(');
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ')':
                        if ('(' != stack.pop()) {
                            flag = 1;
                        }
                        break;
                    case ']':
                        if ('[' != stack.pop()) {
                            flag = 1;
                        }
                        break;
                    default:
                }
            }
            if (stack.empty()&&flag==0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
                flag=0;
            }
            n--;
            stack.clear();
        }
    }
}
