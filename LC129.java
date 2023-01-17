// 129. Sum Root to Leaf Numbers

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        RTLsum(root, new ArrayList<Integer>());
        return this.sum;
        
    }
    
    private int sum = 0;
    public boolean RTLsum(TreeNode node, List<Integer> nums){
        if(node == null) return true;

        nums.add(node.val);

        boolean isLeftLeafNode = RTLsum(node.left, nums) ;
        boolean isRightLeafNode = RTLsum(node.right, nums);

        if(isLeftLeafNode && isRightLeafNode){
            int s = 0;
            for(int i : nums){
                s = (s*10 + i);
            }
            this.sum += s;
        }

        nums.remove(nums.size()-1);

        return false;

    }
}