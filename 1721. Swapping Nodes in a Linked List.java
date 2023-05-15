/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = null, right = null, end = null;
        int t = k;
        left = head;
        while (t > 1 && left != null) {
            left = left.next;
            t--;
        }
        right = head;
        end = left;
        while (end != null && end.next != null) {
            right = right.next;
            end = end.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}