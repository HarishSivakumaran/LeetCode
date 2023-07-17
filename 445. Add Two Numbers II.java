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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int c = 0;

        ListNode h1 = reverse(l1), h2 = reverse(l2), ans = dummy;
        int v1 = 0, v2 = 0;
        while(h1 != null || h2 != null || c > 0) {
            v1 = h1 != null ? h1.val : 0;
            v2 = h2 != null ? h2.val : 0;
            ans.next = new ListNode((v1+v2+c)%10);
            c = (v1+v2+c)/10;
            ans = ans.next;
            if(h1 != null) h1 = h1.next;
            if(h2 != null) h2 = h2.next;
        }

        return reverse(dummy.next);

    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}