// 142. Linked List Cycle II

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode ptr = cycle(head, head);
        if (ptr == null)
            return null;

        while (ptr != head) {
            ptr = ptr.next;
            head = head.next;
        }

        return head;

    }

    public ListNode cycle(ListNode sPtr, ListNode fPtr) {
        while (sPtr != null && fPtr != null) {
            sPtr = sPtr.next;
            fPtr = fPtr.next != null ? fPtr.next.next : null;
            if (sPtr == fPtr) {
                return sPtr;
            }

        }

        return null;

    }
}