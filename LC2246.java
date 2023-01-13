// 2246. Longest Path With Different Adjacent Characters

class Solution {
    int max = 0;
    public int longestPath(int[] parent, String s) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < parent.length; i++){
            if(!adj.containsKey(i)){
                adj.put(i, new ArrayList<>());
            }
            if(parent[i] == -1) continue;

            adj.get(i).add(parent[i]);

             if(!adj.containsKey(parent[i])){
                adj.put(parent[i], new ArrayList<>());
            }
             adj.get(parent[i]).add(i);

        }
        dfs(adj, 0, -10, s);
        return this.max;
        
    }

    public int dfs(HashMap<Integer,List<Integer>> adj, int curr, int prev, String s){

        int count = 1, maxPath = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int edge : adj.get(curr)){
            if(edge == prev) continue;
            pq.add(dfs(adj, edge, curr, s));
        }
        for(int i = 0; i < 2; i++){
            if(pq.size() > 0){
                int m = pq.poll();
                maxPath = Math.max(maxPath, m);
                count += m;
            }
        }
        
        this.max = Math.max(count, this.max);

        return (prev == -10 || s.charAt(curr) != s.charAt(prev)) ? maxPath + 1 : 0;

        
    }
}