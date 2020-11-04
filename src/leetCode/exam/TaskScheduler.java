package leetCode.exam;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task:tasks) {
            map[task-'A']++;
        }
        Arrays.sort(map);
        int maxVal=map[25]-1;
        int idleSlot=maxVal*n;
        for (int i=24;i>-1;i--){
            idleSlot-=Math.min(map[i],maxVal);
        }
        return idleSlot>0 ? idleSlot + tasks.length : tasks.length;
    }

}
