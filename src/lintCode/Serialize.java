package lintCode;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {

    private class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /*    *//**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     *//*
    public String serialize(TreeNode root) {
        // write your code here
        if (null == root) {
            return "{#}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        TreeNode nowNode;
        TreeNode lastNode;
        while (nodeList.size() > 0) {
            nowNode = nodeList.get(nodeList.size() - 1);
            sb.append(root.val).append(",");
            if (nowNode.left!=null){
                nodeList.add(nowNode);
            } else if (nowNode.right!=null){
                nodeList.add(nowNode);
            }
        }
        sb.append(root.val);
        childNodeList.add(root.left);
        childNodeList.add(root.);
    }

    *//**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     *//*
    public TreeNode deserialize(String data) {
        // write your code here
        if ("{#}".equals(data)) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        List<TreeNode> treeNodeList = new ArrayList<>();
        TreeNode nowNode;
        boolean isLeftEmpty = false;
        boolean isRightEmpty = false;
        TreeNode fatherNode;
        for (String str : split) {
            if (treeNodeList.size() == 0) {
                // 初始化
                treeNodeList.add(new TreeNode(Integer.valueOf(str)));
                continue;
            }
            // 获取父节点
            fatherNode = treeNodeList.get(treeNodeList.size() - 1);
            while (null != fatherNode.right || isRightEmpty) {
                isRightEmpty = false;
                treeNodeList.remove(treeNodeList.size() - 1);
                fatherNode = treeNodeList.get(treeNodeList.size() - 1);
            }
            if (!isLeftEmpty && null == fatherNode.left) {
                if ("#".equals(str)) {
                    isLeftEmpty = true;
                } else {
                    fatherNode.left = new TreeNode(Integer.valueOf(str));
                    treeNodeList.add(fatherNode.left);
                    isLeftEmpty = false;
                }
            } else {
                if ("#".equals(str)) {
                    isRightEmpty = true;
                } else {
                    fatherNode.right = new TreeNode(Integer.valueOf(str));
                    treeNodeList.add(fatherNode.right);
                    isLeftEmpty = false;
                }
            }
        }
        return treeNodeList.get(0);
    }*/
    public static void main(String[] args) {
        Serialize serialize = new Serialize();
        TreeNode deserialize = serialize.deserialize("{}");
        System.out.println(serialize.serialize(deserialize));
        deserialize = serialize.deserialize("{3,9,20,#,#,15,7}");
        System.out.println(serialize.serialize(deserialize));
    }

    /**
     * BFS层数优先遍历
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (null == root) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        readBFSTree(sb,root);
        sb.append("}");
        return "{"+sb.toString();
    }

    private StringBuilder readBFSTree(StringBuilder sb, TreeNode root) {
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(root);
        TreeNode poll = null;
        sb.append(root.val);
        while (!nodeList.isEmpty()) {
            poll = nodeList.poll();
            if (null == poll.left) {
                sb.append(",#");
            } else {
                sb.append(",").append(poll.left.val);
                nodeList.offer(poll.left);
            }
            if (null == poll.right) {
                sb.append(",#");
            } else {
                sb.append(",").append(poll.right.val);
                nodeList.offer(poll.right);
            }
        }
        for (int i = sb.length() -1 ; i >0;){
            if (sb.charAt(i)=='#'){
                sb.deleteCharAt(i--);
                sb.deleteCharAt(i--);
            } else {
                break;
            }
        }
        return sb;
    }

    /**
     * BFS层数优先遍历
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        return createBFSTree(split);
    }

    private TreeNode createBFSTree(String str[]) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        int index = 0;
        TreeNode root = createNode(str[index]);
        if (root == null) {
            return null;
        }
        treeNodeQueue.offer(root);
        TreeNode node = null;
        while (!treeNodeQueue.isEmpty()) {
            node = treeNodeQueue.poll();
            if (++index >= str.length) {
                break;
            }
            TreeNode now = createNode(str[index]);
            node.left = now;
            if (null != now) {
                treeNodeQueue.offer(now);
            }
            if (++index >= str.length) {
                break;
            }
            now = createNode(str[index]);
            node.right = now;
            if (null != now) {
                treeNodeQueue.offer(now);
            }
        }
        return root;
    }

    private TreeNode createNode(String date) {
        return !"#".equals(date)&& !"".equals(date)&& null!=date ? new TreeNode(Integer.valueOf(date)) : null;
    }
}
