// 894. All Possible Full Binary Trees

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
    HashMap<Integer, List<TreeNode>> cache = new HashMap();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> out = new ArrayList();
        if (n % 2 == 0)
            return out;
        if (n == 1) {
            out.add(new TreeNode(0));
            return out;
        }
        if (cache.containsKey(n))
            return cache.get(n);
        TreeNode curr = null;

        for (int i = 2; i <= n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i - 1);
            List<TreeNode> right = allPossibleFBT(n - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    curr = new TreeNode(0);
                    curr.left = clone(l);
                    curr.right = clone(r);
                    out.add(curr);
                }
            }
        }

        cache.put(n, out);
        return out;

    }

    public TreeNode clone(TreeNode node) {
        if (node == null)
            return null;
        TreeNode curr = new TreeNode(node.val);
        curr.left = clone(node.left);
        curr.right = clone(node.right);
        return curr;
    }

}