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
        ListNode dummy = new ListNode(-9999);
        dummy.next = head;

        ListNode insPrev = dummy, insCurr = head,
         transPrev = insPrev, transCurr = head;

        while(transCurr != null) { 
            if(transCurr.val < x) {
                if(transCurr == insCurr) {
                    insPrev = insCurr;
                    insCurr = insCurr.next;
                }else{
                transPrev.next = transCurr.next;
                insPrev.next = transCurr;
                transCurr.next = insCurr;
                insPrev = transCurr;
                insCurr = insPrev.next;
                transCurr = transPrev.next;
                continue;
                }
            }
            transPrev = transCurr;
            transCurr = transCurr.next;
        }

        return dummy.next;
    } 
}