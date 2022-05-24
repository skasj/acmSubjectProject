package leetCode.dynamicProgramming;

/**
 * @author ydy
 * @Description:
 * @date: 2022/5/24 2:26 下午
 * @since JDK 1.8
 */
public class ReachNumberSolution {
    public int reachNumber(int target) {
        if (target <0){
            target = -target;
        }
        int i = 1;
        int sum = 1;
        while (!condition(target,sum,i)){
            i++;
            sum += i;
        }
        return i;
    }

    private boolean condition(int target,int sum,int i){
        if (sum < target){
            return false;
        }
        if (target == sum){
            return true;
        }
        if (sum - 2 < target || (target-sum) % 2 !=0){
            return false;
        }
        return i > 2;
    }

    public static void main(String[] args) {
        ReachNumberSolution reachNumberSolution = new ReachNumberSolution();
        System.out.println(reachNumberSolution.reachNumber(1));
        System.out.println(reachNumberSolution.reachNumber(2));
        System.out.println(reachNumberSolution.reachNumber(3));
        System.out.println(reachNumberSolution.reachNumber(4));
        System.out.println(reachNumberSolution.reachNumber(5));
        System.out.println(reachNumberSolution.reachNumber(6));
        System.out.println(reachNumberSolution.reachNumber(7));
        System.out.println(reachNumberSolution.reachNumber(8));
    }
}