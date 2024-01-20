class Solution {
    public int sumSubarrayMins(int[] arr) {
        List<int[]> q = new ArrayList();//val, index
        int[] dp = new int[arr.length+1];
        int mod = 1000000007;
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            while(q.size() > 0 && q.get(q.size()-1)[0] > arr[i])
                 q.remove(q.size()-1);
            
            q.add(new int[]{arr[i],i });
                int[] curr = q.get(q.size()-1);
                int[] prev = q.size()-2 < 0 ? new int[]{Integer.MAX_VALUE, -1} : q.get(q.size()-2);
                dp[curr[1]] = (curr[0]*(curr[1]-prev[1])) + (prev[1] >= 0 ? dp[prev[1]] : 0);
                ans += dp[curr[1]];
                ans %= mod;
        }
        return ans;
    }
}