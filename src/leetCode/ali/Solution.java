package leetCode.ali;

/**
 * date: 2021/2/20 17:52
 * @author dongyu.ye
 * @description:
 * @since 3.1.0
 */

public class Solution {

    public class ListNode {

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
        ListNode listNode = new ListNode();
        boolean addOne = false;
        while (true) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            if (addOne) {
                temp += 1;
            }
            if (temp > 9) {
                temp %= 10;
                addOne = true;
            } else {
                addOne = false;
            }
            sb.append(temp);
            if (l1 == null && l2 == null) {
                if (addOne){
                    sb.append(1);
                } else {

                }
            }
        }
    }
}
