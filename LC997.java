// 997. Find the Town Judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n+1];

        for(int[] t : trust){
            trusted[t[1]]++;
            trusted[t[0]]--;
        }

        for(int i = 1; i <= n; i++){
            if(trusted[i] == n-1) return i;
        }

        return -1;
        
    }
}