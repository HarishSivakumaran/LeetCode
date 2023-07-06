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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = getLen(head);
        k = k%len;
        if( k == 0) return head;

        ListNode l = head, r = head;

        for(int i = 0; i < k; i++){
            r = r.next;
        }

        while(r.next != null){
            l = l.next;
            r = r.next;
        }

        ListNode res = l.next;
        l.next = null;
        r.next = head;

        return res;
    }

    public int getLen(ListNode node){
        int len = 0;

        while(node != null){
            len++;
            node = node.next;
        }

        return len;
    }
}