class Solution {
    public int getLastMoment(int t, int[] left, int[] right) {
        int ans = 0;
        for(int n : left) if(n > ans) ans = n;
        for(int n : right) if(t-n > ans) ans = t-n;
        return ans;
    }
}