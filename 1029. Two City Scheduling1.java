class Solution {
    Integer[][][] cache = null;
    public int twoCitySchedCost(int[][] costs) {
        cache = new Integer[(costs.length/2)+1][(costs.length/2)+1][costs.length];
        return getMin(costs, 0, 0, 0);
    }

    private int getMin(int[][] costs, int index, int n1, int n2) {
        if(index >= costs.length) {
            return 0;
        }


        if(cache[n1][n2][index] != null) return cache[n1][n2][index];

        int group1 = Integer.MAX_VALUE, group2 = Integer.MAX_VALUE;

        if(n1 < costs.length/2) {
            group1 = costs[index][0] + getMin(costs, index+1, n1+1, n2);
        }

        if(n2 < costs.length/2) {
            group2 = costs[index][1] + getMin(costs, index+1, n1, n2+1); 
        }

        return cache[n1][n2][index] = Math.min(group1, group2);
    }
}