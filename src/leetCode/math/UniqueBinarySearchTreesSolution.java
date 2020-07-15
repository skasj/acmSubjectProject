package leetCode.math;
import java.util.LinkedList;


public class UniqueBinarySearchTreesSolution {
    class Node {
        int un,ln,uc;

        Node(int un,int ln,int uc){
            this.un = un;
            this.ln = ln;
            this.uc = uc;
        }
    }

    /**
     * 解题思路：
     * 需要记录的有：
     * 1. 上一层的节点数量 UN
     * 2. 余留的节点数量 LN
     * 3. 上一层的累计组合数量 UC
     *
     **/
    public int numTrees(int n) {
        int count =0;
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(new Node(1,n-1,1));
        Node last;
        int useNum;
        while (!nodeList.isEmpty()){
            last = nodeList.getLast();
            nodeList.removeLast();
            if (0 == last.ln){
                count += last.uc;
                continue;
            }
            useNum = Math.min(last.un<<1,last.ln);
            while (useNum>0){
                nodeList.add(new Node(useNum, last.ln - useNum, last.uc * CNMCalculation(useNum,last.un<<1)));
                useNum--;
            }
        }
        return count;
    }

    private int CNMCalculation(int m,int n){
        if (m > n /2){
            m = n-m;
        }
        int j=1,k =1;
        while (m!=0){
            j *= m--;
            k *= n--;
        }
        return k/j;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesSolution solution = new UniqueBinarySearchTreesSolution();
//        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(4));
    }

    /**
     * 高数解题思路..... 卡特兰数
     *
     **/
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        double C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
