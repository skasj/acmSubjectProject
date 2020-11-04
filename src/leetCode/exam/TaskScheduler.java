package leetCode.exam;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int allNum = tasks.length;
        Integer[] counts = new Integer[26];
        Arrays.fill(counts, 0);
        for (char task : tasks) {
            counts[(int) task - 65]++;
        }
        int temp =0;
        int result = 0;
        long count ;
        while (allNum != 0){
            temp=n+1;
            count = Arrays.stream(counts).filter(o -> o>0).count();
            Arrays.sort(counts, Comparator.reverseOrder());
            for (int i =0;i<count && temp >0;i++,temp--) {
                counts[i]--;
                allNum --;
            }
            result += n+1;
        }
        return result - temp;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
//        Assert.assertEquals(6,taskScheduler.leastInterval(new char[]{'A','A','B','B','A','B'}, 0));
//        Assert.assertEquals(8,taskScheduler.leastInterval(new char[]{'A','A','B','B','A','B'}, 2));
//        Assert.assertEquals(12,taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'}, 2));
        Assert.assertEquals(10,taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E'}, 2));
        Assert.assertEquals(52,taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'}, 2));
    }
}
