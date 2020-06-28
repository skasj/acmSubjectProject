package aLevel1to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellItRight {
    enum Num {
        ZERO('0', 0, "zero"), ONE('1', 1, "one"), TWO('2', 2, "two"), THREE('3', 3, "three"), FOUR('4', 4, "four"), FIVE('5', 5, "five"),
        SIX('6', 6, "six"), SEVEN('7', 7, "seven"), EIGHT('8', 8, "eight"), NINE('9', 9, "nine");

        Num(char c, int i, String word) {
            this.i = i;
            this.c = c;
            this.word = word;
        }

        public static Num valueOfByChar(char c) {
            for (Num num : Num.values()) {
                if (c == num.c) {
                    return num;
                }
            }
            return null;
        }

        public static Num valueOfByInt(int i) {
            for (Num num : Num.values()) {
                if (i == num.i) {
                    return num;
                }
            }
            return null;
        }

        char c;
        int i;
        String word;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int sum = 0;
        for (char c:n.toCharArray()){
            sum += Num.valueOfByChar(c).i;
        }
        String sumString = String.valueOf(sum);
        List<String> numList =new ArrayList<>();
        for (char c:sumString.toCharArray()){
            numList.add(Num.valueOfByChar(c).word);
        }
        System.out.println(String.join(" ",numList.toArray(new String[sumString.length()])));
    }
}
