package aLevel1to100;

import java.util.*;

public class CountingLeaves {

    static class Node {
        List<Integer> leafNodeNos;
        int no;
    }

    private static Scanner scanner = new Scanner(System.in);

    private static int nonLeafNodesNum;

    private static List<String> record = new ArrayList<>();

    private static HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    public static void main(String arg[]) {
        int nodesNum = scanner.nextInt();
        nonLeafNodesNum = scanner.nextInt();
        nodeHashMap = generateTree();
        setRecord();
        System.out.println(String.join(" ", record.toArray(new String[record.size()])));
    }

    private static HashMap<Integer, Node> generateTree() {
        for (int i = 0; i < nonLeafNodesNum; i++) {
            Node node = getNode();
            nodeHashMap.put(node.no, node);
        }
        return nodeHashMap;
    }

    private static Node getNode() {
        Node node = new Node();
        node.no = scanner.nextInt();
        node.leafNodeNos = getListChildren(scanner.nextInt());
        return node;
    }

    private static List<Integer> getListChildren(int n) {
        List<Integer> listOfChildren = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listOfChildren.add(scanner.nextInt());
        }
        return listOfChildren;
    }

    private static List<String> setRecord() {
        if (nodeHashMap.isEmpty()) {
            record.add("1");
            return record;
        } else {
            List<Integer> nonLeafNode = new ArrayList<>();
            nonLeafNode.add(1);
            addRecord(nonLeafNode, record);
        }
        return record;
    }

    private static void addRecord(List<Integer> noList, List<String> record) {
        int noLeafNodeNum = 0;
        List<Integer> nonLeafNode = new ArrayList<>();
        for (Integer no : noList) {
            if (null == nodeHashMap.get(no)) {
                noLeafNodeNum++;
                continue;
            }
            List<Integer> nodeNoList = nodeHashMap.get(no).leafNodeNos;
            nonLeafNode.addAll(nodeNoList);
        }
        record.add(String.valueOf(noLeafNodeNum));
        if (!isEmpty(nonLeafNode)) {
            addRecord(nonLeafNode, record);
        }
    }

    private static boolean isEmpty(List list) {
        return null == list || list.isEmpty();
    }
}
