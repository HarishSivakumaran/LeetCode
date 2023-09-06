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
        ListNode[] out = new ListNode[k];
        int len = getLen(head);
        int groupSize = len/k;
        int remain = len%k;

        for(int i = 0; i < k; i++) {
            int size = groupSize + (remain > 0 ? 1 : 0);
            remain--;
            int l = 1;
            if(head == null) break;
            out[i] = head;
            while(l < size) {
                head = head.next;
                l++;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }

        return out;
    }

    private int getLen(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }

        return l;
    }
}