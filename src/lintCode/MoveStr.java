package lintCode;

/**
 * lintCode 第8题，旋转字符串
 */
public class MoveStr {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(null ==str || str.length == 0 || offset == 0){
            return;
        }
        offset = offset % str.length;
        flipStr(str,0,str.length-offset-1);
        flipStr(str,str.length-offset,str.length-1);
        flipStr(str,0,str.length-1);
    }

    private void flipStr(char[] str,int sindex ,int eindex){
        char tmp;
        for (int i = sindex; i <= (eindex+sindex)/2; i++) {
            tmp = str[i];
            str[i] = str[eindex +sindex-i];
            str[eindex+sindex-i] = tmp;
        }
    }



    public static void main(String[] args) {
        MoveStr moveStr = new MoveStr();
        String s = new String("timelimiterror");
        char[] chars = s.toCharArray();
        moveStr.rotateString(chars,1000000000);
        System.out.println(chars);
    }
}
