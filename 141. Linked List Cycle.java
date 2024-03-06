/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode sPtr = head, fPtr = head;

        do{
            sPtr = sPtr.next;
            if(fPtr != null && fPtr.next != null) {
                fPtr = fPtr.next.next;
            } else {
                return false;
            }
        } while(sPtr != fPtr);

        return true;
    }
}