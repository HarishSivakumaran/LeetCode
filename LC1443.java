// 1443. Minimum Time to Collect All Apples in a Tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean shouldProceed = false;

        for(boolean hasApp : hasApple){
            shouldProceed = shouldProceed || hasApp;
        }

        if(!shouldProceed || edges.length == 0 ) return 0;

        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            if(!adj.containsKey(edge[0])){
                adj.put(edge[0], new ArrayList());
            }
            adj.get(edge[0]).add(edge[1]);
            if(!adj.containsKey(edge[1])){
                adj.put(edge[1], new ArrayList());
            }
            adj.get(edge[1]).add(edge[0]);
        }  

        return dfs(adj, 0, hasApple, -1);    
    }

    public int dfs(HashMap<Integer, List<Integer>> adj, int curr,  List<Boolean> hasApple, int prev){
        if(!adj.containsKey(curr)) return hasApple.get(curr) ? 2 : 0; // leaf nodes

        int time = 0;

        for(int adjNode : adj.get(curr)){
            if(adjNode == prev) continue;
            time += dfs(adj, adjNode, hasApple, curr);
        }

        if(curr != 0 && (time > 0 || hasApple.get(curr))) time +=2;

        return time;
        
    }

}