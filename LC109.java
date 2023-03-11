// 109. Convert Sorted List to Binary Search Tree

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        List<Integer> arr = new ArrayList();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return createBST(arr, 0, arr.size() - 1);
    }

    public TreeNode createBST(List<Integer> list, int l, int r) {
        if (l > r)
            return null;
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(list.get(m), createBST(list, l, m - 1), createBST(list, m + 1, r));
        return node;
    }
}