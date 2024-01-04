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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLen(head);
        int size = len/k, change = -1;
        if(len%k != 0) {
            change = (len%k);
        }

        ListNode[] out = new ListNode[k];

        for(int i = 0; i < k; i++) {
            int reqLen = size + (i < change ? 1 : 0);
            out[i] = head;
            if(head != null){
                ListNode prev = head;
                while(reqLen > 0) {
                    prev = head;
                    head = head.next;
                    reqLen--;
                }
                prev.next = null;
            }
        }

        return out;
        
    }

    private int getLen(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}