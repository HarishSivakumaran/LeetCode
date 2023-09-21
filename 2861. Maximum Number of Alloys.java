class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition,
                                 List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        
        for(List<Integer> comp : composition) {
            long max = 0;
            for(int i = 0; i < n; i++) {
                max = Math.max(max, (long)stock.get(i)+(budget/cost.get(i)));
            }
            
            long l = 0, r = max, m = 0;
            while(l <= r) {
                m = l + (r-l)/2;
                if(doable(comp, stock, cost, budget, m)) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
            ans = Math.max(ans, (int)r);
        }
        
        return ans;
    }
    
    private boolean doable(List<Integer> comp,
                                 List<Integer> stock, List<Integer> cost, int budget, long m) {
        long amount = 0;
        for(int i = 0; i < comp.size(); i++) {
            if((long)(m*comp.get(i)) > stock.get(i))
                amount += (long)((m*comp.get(i))-stock.get(i))*(long)cost.get(i);
            if(amount > budget) return false;
        }
        
        return true;
    }
}