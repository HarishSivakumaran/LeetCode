// 103. Binary Tree Zigzag Level Order Traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList();
        if (root == null)
            return out;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean isReverse = false;
        int l = 0, r = 0;

        while (q.size() > 0) {
            int len = q.size();
            List<Integer> arr = new ArrayList();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                arr.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (isReverse) {
                l = 0;
                r = arr.size() - 1;
                while (l < r) {
                    int temp = arr.get(l);
                    arr.set(l, arr.get(r));
                    arr.set(r, temp);
                    l++;
                    r--;
                }
            }
            out.add(arr);
            isReverse = !isReverse;

        }

        return out;

    }
}

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList();
        if (root == null)
            return out;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean isReverse = false;
        int l = 0, r = 0;

        while (q.size() > 0) {
            int len = q.size();
            List<Integer> arr = new ArrayList();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                arr.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (isReverse) {
                l = 0;
                r = arr.size() - 1;
                while (l < r) {
                    int temp = arr.get(l);
                    arr.set(l, arr.get(r));
                    arr.set(r, temp);
                    l++;
                    r--;
                }
            }
            out.add(arr);
            isReverse = !isReverse;

        }

        return out;

    }
}