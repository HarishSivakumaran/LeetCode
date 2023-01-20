// 257. Binary Tree Paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList();
        rtlPaths(root, new StringBuilder(""), out);
        return out;
        
    }

    public boolean rtlPaths(TreeNode node, StringBuilder str, List<String> out){
        if(node == null) return true;
        
        int pos = str.length();
        str.append(str.length() == 0 ? node.val : ("->" + node.val));

        boolean left = rtlPaths(node.left, str, out);
        boolean right = rtlPaths(node.right, str, out);

        if(left && right){
            //leaf node
            out.add(str.toString());
        }

        str.replace(pos, str.length(), "");


        return false;

    }
}