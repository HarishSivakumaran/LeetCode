// 23. Merge k Sorted Lists

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node : lists){
            while(node != null){
                pq.add(node.val);
                node= node.next;
            }
        }
        ListNode res = new ListNode(), curr = res;

        while(pq.size() != 0){
            curr.next = new ListNode(pq.poll());
            curr = curr.next;
        }
    //     while(curr != null){
    //     curr.next = findNextMinNode(lists);
    //     curr = curr.next;
    // }

    return res.next;

           
    }

    public ListNode findNextMinNode(ListNode[] lists){
        Integer minNode = null;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;
            if(minNode == null || lists[i].val < lists[minNode].val){
                minNode = i;
            }                       
        }

        if(minNode == null) return null;

        ListNode newNode = new ListNode(lists[minNode].val);
        lists[minNode] = lists[minNode].next;
        return newNode;
    }
}