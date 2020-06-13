//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

//Java：两数相加
class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(1);
        ListNode temp1 = l1;
        temp1.next = new ListNode(8);
        temp1 = temp1.next;
        temp1.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        ListNode temp2 = l2;

        temp2.next = new ListNode(6);
        temp2 = temp2.next;
        temp2.next = new ListNode(4);
        solution.addTwoNumbers(l1, l2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            int card = 0;
            while (l1 != null || l2 != null) {
                int sum;
                if (l1 != null && l2 != null) {
                    sum = l1.val + l2.val + card;
                } else if (l1 == null) {
                    sum = l2.val + card;
                } else {
                    sum = l1.val + card;
                }
                card = sum / 10;
                temp.next = new ListNode(sum % 10);
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                temp = temp.next;
            }

            if (card == 1) {
                temp.next = new ListNode(1);
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}