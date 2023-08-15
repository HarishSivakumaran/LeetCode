/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-9999), insert = dummy,
         prev = dummy, curr = head, next = null;
         dummy.next = head;

         while(curr != null) {
             if(curr.val < x && curr != insert.next) {
                 next = curr.next;
                 curr.next = insert.next;
                 insert.next = curr;
                 insert = curr;
                 curr = next;
                 prev.next = next;
             } else {
                 if(curr.val < x ) insert = insert.next;
                 prev = curr;
                 curr = curr.next;
             }
         }

         return dummy.next;
    }
}