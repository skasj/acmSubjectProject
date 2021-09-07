package leetCode.sort;

import java.util.PriorityQueue;

public class FindMaximizedCapitalSolution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> all = new PriorityQueue<>((x,y)->x[0]-y[0]);
        for (int i = 0; i < profits.length; i++) {
            all.add(new int[]{capital[i],profits[i]});
        }
        PriorityQueue<Integer> available = new PriorityQueue<>((x,y)->y-x);
        while (k>0){
            while (!all.isEmpty() && all.peek()[0]<=w){
                available.add(all.poll()[1]);
            }
            if (available.isEmpty()){
                return w;
            }
            w+=available.poll();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        FindMaximizedCapitalSolution solution = new FindMaximizedCapitalSolution();
        System.out.println(solution.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}
