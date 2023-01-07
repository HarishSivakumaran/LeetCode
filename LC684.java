// 684. Redundant Connection

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            hm.put(i+1, new HashSet<Integer>());
        }

        for(int[] edge : edges){
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }   

        HashSet<String> cyclicEdges = new HashSet<>();

        traverse(1, new HashSet<Integer>(), -1, cyclicEdges, hm);  

        for(int i = edges.length-1; i >= 0 ; i--){
            if(cyclicEdges.contains(edges[i][0]+"-"+edges[i][1]) || cyclicEdges.contains(edges[i][1]+"-"+edges[i][0]) ) return edges[i];
        }

        return edges[0];


    }

    public int traverse(int c, HashSet<Integer> visited, int prev, HashSet<String> cyclicEdges,  HashMap<Integer, HashSet<Integer>> edges){
        
        if(visited.contains(c)){
            // found a cycle
            cyclicEdges.add(c+"-"+prev);
            return c;
        }

        visited.add(c);

        int cyclicNode = -1;

        for(Integer i : edges.get(c)){
            if(i == prev) continue;
            cyclicNode = traverse(i, visited, c, cyclicEdges, edges);    
            if(cyclicNode != -1){
                break;
            } 
        }

         visited.remove(c);
       
        if(visited.contains(cyclicNode)) cyclicEdges.add(c+"-"+prev);

        return cyclicNode; // no cycle here
    }

}