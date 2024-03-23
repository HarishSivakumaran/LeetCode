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
    public void reorderList(ListNode head) {
        ListNode sPtr = head, fPtr = head.next;

        while (fPtr != null && fPtr.next != null) {
            sPtr = sPtr.next;
            fPtr = fPtr.next.next;
        }

        fPtr = reverse(sPtr.next);
        sPtr.next = null;
        sPtr = head;

        while (sPtr != null && fPtr != null) {
            ListNode next = sPtr.next, next2 = fPtr.next;
            sPtr.next = fPtr;
            fPtr.next = next;
            fPtr = next2;
            sPtr = next;
        }
    }

    private ListNode reverse(ListNode n) {
        ListNode prev = null, curr = n, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}