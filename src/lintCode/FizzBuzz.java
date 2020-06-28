package lintCode;

import java.util.ArrayList;
import java.util.List;
public class FizzBuzz {

    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        int row = 0;
        int col = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 0;i<n;i++){
            String num = "";
            if (row == 2 && col == 4){
                num = "fizz buzz";
                row = 0;
                col = 0;
            } else if (row == 2){
                num = "fizz";
                row=0;
                ++col;
            } else if (col == 4){
                num = "buzz";
                ++row;
                col=0;
            } else {
                num = "" +(i+1);
                ++row;
                ++col;
            }
            strings.add(num);
        }
        return strings;
    }
}
