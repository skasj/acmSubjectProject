package leetCode.exam;

import java.util.Random;

public class DuplicatesString {
    public String removeDuplicates(String s, int k) {
        if (s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        int count =0;
        char nullTag = '0';
        char last = nullTag;
        for (int i=0;i<chars.length;i++){
            if (chars[i]==nullTag) {
                continue;
            }
            if (last!=chars[i]){
                last = chars[i];
                count = 1;
                continue;
            }
            count++;
            if (count!=k){
                continue;
            }
            int j=i;
            for (;j>-1;j--){
                if (chars[j]==nullTag) {
                    continue;
                }
                chars[j]=nullTag;
                count--;
                if (0==count){
                    break;
                }
            }
            while (j>0){
                j--;
                if (chars[j]!=nullTag){
                    last =chars[j];
                    break;
                }
            }
            count = 0;
            for (;j>-1;j--){
                if (chars[j]!=nullTag&&chars[j]!=last){
                    break;
                } else if (chars[j]==last){
                    count++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            if (chars[i]!=nullTag){
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DuplicatesString duplicatesString = new DuplicatesString();
        String s = "pbbcggttciiippooaais";
        Random random = new Random();
        System.out.println(random.nextInt(1));
        System.out.println(duplicatesString.removeDuplicates(s, 2));
        System.out.println((int) 'z');
    }
}
