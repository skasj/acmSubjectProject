package leetCode.exam;

public class TreeSolution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int[] inorder;
    int[] postorder;
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 后续遍历的最后一个节点时根节点
        // 根据这个特性，将中序节点递归建立树。
        this.inorder=inorder;
        this.postorder=postorder;
        return buildTree(0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildTree(int is,int ie,int ps,int pe){
        if (is>ie || ps>pe){
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[pe]);
        int iroot = 0;
        for (int i=is;i<=ie;i++){
            if (inorder[i]==postorder[pe]){
                iroot=i;
                break;
            }
        }
        int plimit = ps-1+iroot-is;

        treeNode.left = buildTree(is,iroot-1,ps,plimit);
        treeNode.right = buildTree(iroot+1,ie,plimit+1,pe-1);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeSolution treeSolution = new TreeSolution();
        System.out.println("中序遍历");
        treeSolution.inPrintTree(treeSolution.buildTree(new int[]{2,3,1},new int[]{3,2,1}));
        System.out.println("\n后序遍历");
        treeSolution.postPrintTree(treeSolution.buildTree(new int[]{2,3,1},new int[]{3,2,1}));
        System.out.println("中序遍历");
        treeSolution.inPrintTree(treeSolution.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
        System.out.println("\n后序遍历");
        treeSolution.postPrintTree(treeSolution.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
    }

    private void inPrintTree(TreeNode t){
        if (t==null){
            return;
        }
        inPrintTree(t.left);
        System.out.print(t.val+" ");
        inPrintTree(t.right);
    }

    private void postPrintTree(TreeNode t){
        if (t==null){
            return;
        }
        postPrintTree(t.left);
        postPrintTree(t.right);
        System.out.print(t.val+" ");
    }
}
