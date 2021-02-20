package leetCode;

import org.junit.Assert;

/**
 * date: 2021/2/20 11:14
 * @author dongyu.ye
 * @see <a href="https://leetcode-cn.com/problems/IQvJ9i/">LCP 27. 黑盒光线反射</a>
 * @description:
 * @since 3.1.0
 */
public class BlackBox {

    boolean[] states;
    int[] next1;
    int[] next2;

    public BlackBox(int n, int m) {
        int num = 2 * (n + m);

        states = new boolean[num];
        next1 = new int[num];
        next2 = new int[num];
        for (int i = 0; i < num; i++) {
            next1[i] = (num - i) % num;
            next2[i] = (2 * m - i + num) % num;
        }
    }

    public int open(int index, int direction) {
        states[index] =true;
        int next = direction==1?next1[index]:next2[index];
        while (states[next]){
            next = direction == 1 ? next2[next] : next1[next];
            direction = -direction;
        }
        return next;
    }

    public void close(int index) {
        states[index] =false;
    }

    public static void main(String[] args) {
        BlackBox blackBox = new BlackBox(2, 3);
        Assert.assertEquals(6,blackBox.open(6,-1));
        Assert.assertEquals(4,blackBox.open(4,-1));
        Assert.assertEquals(6,blackBox.open(0,-1));
        blackBox.close(6);
        Assert.assertEquals(4,blackBox.open(0,-1));
    }
}
