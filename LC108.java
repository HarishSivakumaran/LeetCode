// 108. Convert Sorted Array to Binary Search Tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = buildTree(nums, l, m - 1);
        node.right = buildTree(nums, m + 1, r);
        return node;
    }

}