package leetCode.exam;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] initInt = new int[26];
        for (char task:tasks){
            initInt[(int) task - 65]++;
        }
        Integer[] counts = new Integer[26];
        for (int i =0;i<initInt.length;i++) {
            counts[i]= initInt[i];
        }
        int minC=Integer.MAX_VALUE;
        int survivor;
        int lastAdd=0;
        int result = 0;
        while (true){
            survivor = 0;
            Arrays.sort(counts, Comparator.reverseOrder());
            for (Integer count : counts) {
                if (count > 0) {
                    minC = count;
                    survivor++;
                }
            }
            if (survivor ==0){
                break;
            }
            if (n+1>survivor){
                for (int i = 0;i<counts.length;i++){
                    if (counts[i]>0){
                        counts[i] -= minC;
                    }
                }
                lastAdd = n+1-survivor;
            } else {
                survivor = n+1;
                for (int i=0;i<counts.length;i++){
                    if (counts[i]>0){
                        counts[i] -= minC;
                        survivor--;
                        if (survivor==0){
                            break;
                        }
                    }
                }
            }
            result += minC * (n+1);
        }
        return result - lastAdd;
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
