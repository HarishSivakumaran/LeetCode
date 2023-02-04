// 501. Find Mode in Binary Search Tree

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
    int max = 0;

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap();
        HashMap<Integer, LinkedHashSet<Integer>> freqList = new HashMap();
        dfs(root, freq, freqList);
        LinkedHashSet<Integer> maxFreq = freqList.get(max);
        int[] out = new int[maxFreq.size()];
        int j = 0;

        for (Integer i : maxFreq) {
            out[j++] = i;
        }

        return out;
    }

    public void dfs(TreeNode node, HashMap<Integer, Integer> freq, HashMap<Integer, LinkedHashSet<Integer>> freqList) {
        if (node == null)
            return;

        int newFreq = 1;
        if (!freq.containsKey(node.val)) {
            freq.put(node.val, 1);
        } else {
            int currfreq = freq.get(node.val);
            newFreq = currfreq + 1;
            freq.put(node.val, newFreq);
            freqList.get(currfreq).remove(node.val);
        }
        freqList.computeIfAbsent(newFreq, v -> new LinkedHashSet()).add(node.val);
        max = Math.max(freq.get(node.val), max);

        dfs(node.left, freq, freqList);
        dfs(node.right, freq, freqList);

    }
}