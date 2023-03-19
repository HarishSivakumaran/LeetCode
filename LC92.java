// 92. Reverse Linked List II

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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if (l == r)
            return head;

        ListNode left = head, right = head, prev = null, curr = null, next = null;

        for (int i = 0; i < r - l && right.next != null; i++) {
            right = right.next;
        }
        int j = l;

        while (j > 1 && right.next != null) {
            prev = left;
            left = left.next;
            right = right.next;
            j--;
        }
        curr = left;
        left = prev;
        prev = right.next;

        for (int i = l; i <= r; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (left != null) {
            left.next = prev;
            return head;
        }

        return prev;

    }
}