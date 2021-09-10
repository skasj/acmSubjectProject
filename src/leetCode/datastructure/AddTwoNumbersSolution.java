package leetCode.datastructure;

public class AddTwoNumbersSolution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        if (length1 < length2) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode result = l1;
        int flag = 0;
        ListNode pre = null;
        while (l2 != null) {
            l1.val += l2.val + flag;
            if (l1.val >= 10) {
                l1.val %= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (flag == 1) {
            if (l1 == null) {
                pre.next = new ListNode(1);
                flag = 0;
            } else {
                l1.val += flag;
                if (l1.val >= 10) {
                    l1.val %= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                pre = l1;
                l1 = l1.next;
            }
        }
        return result;
    }

    private int getLength(ListNode l1) {
        ListNode h = l1;
        int count = 1;
        while (h.next != null) {
            h = h.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
//        ListNode l1 = new ListNode(0);
//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(0);
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
