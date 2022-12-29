// 178 · Graph Valid Tree

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    public HashMap<Integer,List<Integer>> hm = new HashMap<>();
    public HashSet<Integer> counter = new HashSet();
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges.length == 0 ) return n < 2;

        for(int[] e : edges){
            int node1 = e[0];
            int node2 = e[1];
            if(!this.hm.containsKey(node1)){
                this.hm.put(node1, new ArrayList<>());
            }
            if(!this.hm.containsKey(node2)){
                this.hm.put(node2, new ArrayList<>());
            }

            this.hm.get(node1).add(node2);
            this.hm.get(node2).add(node1);
        }

        HashSet<Integer> visited = new HashSet();

        return dfs(0, visited, -1) && counter.size() == n;
    }

    public boolean dfs(int i, HashSet<Integer> visited, int prev){

        if(visited.contains(i)) return false;

        this.counter.add(i);

        visited.add(i);

        boolean notCyclic = true;

        for(int j : this.hm.get(i)){
            if(j == prev) continue;
           notCyclic = dfs(j, visited, i);

           if(!notCyclic){
                visited.remove(i);
                return false;
           }
        }

        visited.remove(i);
        return true;

    }
}