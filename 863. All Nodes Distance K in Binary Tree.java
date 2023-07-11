/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> out = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        // build Parent Map
        dfs(root);

        // BFS your way till you reach k-th level
        HashSet<TreeNode> visited = new HashSet();

        q.add(target);

        int level = 0;

        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                visited.add(curr);
                if (level == k) {
                    out.add(curr.val);
                }

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                }

                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                }
            }

            if (level == k)
                break;
            level++;
        }

        return out;

        // List<TreeNode> bfsList = new ArrayList();
        // List<Integer> out = new ArrayList();
        // Queue<TreeNode> q = new LinkedList();
        // q.add(root);
        // int index = 0;

        // while(!q.isEmpty()){
        // int len = q.size();
        // boolean foundNonNull = false;
        // for(int i = 0; i < len; i++){
        // TreeNode curr = q.poll();
        // bfsList.add(curr);
        // if(curr != null){
        // if(curr == target) index = bfsList.size()-1;
        // q.add(curr.left);
        // q.add(curr.right);
        // if(curr.left != null || curr.right != null) foundNonNull = true;
        // }else{
        // q.add(null);
        // q.add(null);
        // }
        // }

        // if(!foundNonNull) break;
        // }

        // System.out.println(bfsList);
        // int t = k;

        // for(int i = 0; i < bfsList.size(); i++) {
        // if(((i+1)/(2*k) == index+1 || (index+1)/(2*k) == i+1) && bfsList.get(i) !=
        // null){
        // out.add(bfsList.get(i).val);
        // }
        // }

        // return out;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null) {
            parent.put(node.left, node);
            dfs(node.left);
        }

        if (node.right != null) {
            parent.put(node.right, node);
            dfs(node.right);
        }
    }
}