// 382. Linked List Random Node

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

    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
        
    }
    
    public int getRandom() {
       int chosen = 0, scope = 1;
       ListNode curr = this.head;

       while(curr != null){
           if(Math.random() < 1.0/scope) chosen = curr.val;

           scope++;
           curr = curr.next;
       }

       return chosen;

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */