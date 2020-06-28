package leetCode.array;

public class TictactoeSolution {

    /**
     * 井字游戏
     * 1. 增加两列char数组和两个数字，分别来标记当前行列、斜杠、反斜杠的OX空格
     * 2. 增加两列数组和两个数字，分别来标记当前行列、斜杠、反斜杠的相同字符的数字，-1代表已有不相同的字符，其他代表已有相同的字符的数量
     *
     * @param board
     * @return
     */
    public String tictactoe(String[] board) {
        char[] rowCharTag = new char[board.length];
        int[] rowNumTag = new int[board.length];
        char[] colCharTag = new char[board.length];
        int[] colNumTag = new int[board.length];
        char[] slashCharTag = new char[2];
        int[] slashNumTag = new int[2];
        char[] chars;
        String result = "Draw";
        for (int i=0;i<board.length;i++){
            chars = board[i].toCharArray();
            for (int j=0;j<chars.length;j++){
                if (chars[j] == ' '){
                    result = "Pending";
                    continue;
                }
                // 判断列
                if (compareAndSet(colCharTag, colNumTag, j, chars[j], board.length)) {
                    return String.valueOf(chars[j]);
                }
                // 判断行
                if (compareAndSet(rowCharTag, rowNumTag, i, chars[j], board.length)) {
                    return String.valueOf(chars[j]);
                }
                // 判断斜杠
                if (i==j && slashNumTag[0] >-1){
                    if (compareAndSet(slashCharTag, slashNumTag, 0, chars[j], board.length)) {
                        return String.valueOf(chars[j]);
                    }
                }
                if (i+j == chars.length-1 && slashNumTag[1] >-1){
                    if (compareAndSet(slashCharTag, slashNumTag, 1, chars[j], board.length)) {
                        return String.valueOf(chars[j]);
                    }
                }
            }
        }
        return result;
    }

    private boolean compareAndSet(char[] charTag, int[] numTag, int j, char aChar, int length) {
        if (numTag[j]<0){
            // do nothing
        } else if (charTag[j] == aChar){
            return ++numTag[j] == length;
        } else if (charTag[j] == ' ' || charTag[j] == 0) {
            charTag[j] = aChar;
            return ++numTag[j] == length;
        } else {
            numTag[j] = -1;
        }
        return false;
    }

    public static void main(String[] args) {
        TictactoeSolution solution = new TictactoeSolution();
        System.out.println(solution.tictactoe(new String[]{"OOXXOXXX","XXXOXOXO","OXOXXXOO","XOXOXXXX","OXOOXOOO","XOOOOOOO","OXXXOOOX","XOXOOXXX"}));
    }
}
