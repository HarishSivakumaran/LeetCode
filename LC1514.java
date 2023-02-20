// 1514. Path with Maximum Probability

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        int[] edge = null;
        boolean isChanged = false;
        maxProb[start] = 1;
        for(int i = 0; i < n-1; i++){
            isChanged = false;
            for(int j = 0; j < edges.length; j++){
                edge = edges[j];
                if(maxProb[edge[0]] < maxProb[edge[1]]*succProb[j]){
                    isChanged = true;
                    maxProb[edge[0]] = maxProb[edge[1]]*succProb[j]; }            
                if(maxProb[edge[1]] < maxProb[edge[0]]*succProb[j]){ 
                    isChanged = true;
                    maxProb[edge[1]] = maxProb[edge[0]]*succProb[j]; }            
            }
            if(!isChanged) break;
        }

        return maxProb[end];
        
    }
}