class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];
        for(int[] t : trust) {
            trusts[t[0]]++;
            trusts[t[1]]--;
        }

        for(int i = 1; i <= n; i++) {
            if(trusts[i] == (-(n-1))) return i;
        }
        return -1;
    }
}