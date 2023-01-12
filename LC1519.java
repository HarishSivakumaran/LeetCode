// 1519. Number of Nodes in the Sub-Tree With the Same Label

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();

        for(int[] edge : edges){
            if(!hm.containsKey(edge[0])){
                hm.put(edge[0], new ArrayList());
            }
            hm.get(edge[0]).add(edge[1]);

            if(!hm.containsKey(edge[1])){
                hm.put(edge[1], new ArrayList());
            }
            hm.get(edge[1]).add(edge[0]);
        }
        int[] out = new int[n];

        dfs(hm, labels, 0, -1, out);

        return out;
        
    }

    public int[] dfs(HashMap<Integer,List<Integer>> hm, String labels, int curr, int prev,  int[] out){

        int[] child = new int[26];

        out[curr] = 1;

        child[labels.charAt(curr)-'a'] = 1;
        
        for(int i : hm.get(curr)){
            if(i == prev) continue;
            int[] child1 = dfs(hm, labels, i, curr, out);
            for(int k = 0; k < 26; k++){
                child[k] += child1[k];
            }
        }

        out[curr] = child[labels.charAt(curr)-'a'];

        return child;

    }
}