package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchRange {

    private class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> solution(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> integers = new ArrayList<>();
        if (null == root) {
            return integers;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        do {
            if (root!=null && null != root.left) {
                nodeStack.push(root);
                root = root.left;
            } else {
                if (root == null){
                    root = nodeStack.pop();
                }
                if (k1 <= root.val && root.val <= k2) {
                    integers.add(root.val);
                }
                root = root.right;
            }
        } while (!nodeStack.empty() || root!=null);
        return integers;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(searchRange.solution(searchRange.testData(), 10, 22));
    }

    private TreeNode testData(){
        TreeNode t1 = new TreeNode(20);
        t1.left = new TreeNode(8);
        t1.right = new TreeNode(22);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(12);
        return t1;
    }
}
