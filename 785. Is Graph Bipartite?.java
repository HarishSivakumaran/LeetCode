class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] sides = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            // unvisites node -> choose sides
            if(sides[i] == 0 && !checkBipartiteLogic(sides, i, graph, 1)) return false;
        }

        return true;
    }

    private boolean checkBipartiteLogic(int[] sides, int i, int[][] adjList, int expSide) {
      if(sides[i] != 0 && sides[i] != expSide) return false;
      if(sides[i] != 0) return true;

      sides[i] = expSide;

      boolean isBipartite = true;

      for(int n : adjList[i]){
          isBipartite &= checkBipartiteLogic(sides, n, adjList, expSide == 1 ? 2 : 1);
          if(!isBipartite) break;
      }

      return isBipartite;
    }
}