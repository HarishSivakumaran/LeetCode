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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head, next = null;
        int val = 0;
        
        while(curr.next != null) {
            next = curr.next;
            val = gcd(curr.val, curr.next.val); 
            curr.next = new ListNode(val);
            curr.next.next = next;
            curr = next;
        }
        
        return head;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;      
        return gcd(b, a%b);
    }
}