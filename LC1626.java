// 1626. Best Team With No Conflicts

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] pair = new int[ages.length][2];

        for(int i = 0; i < scores.length; i++){
            pair[i][0] = ages[i];
            pair[i][1] = scores[i];
        }

        Integer[][] dp = new Integer[scores.length][scores.length];

        Arrays.sort(pair, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        return getBestTeam(0, pair, -1, dp);

    }

    public int getBestTeam(int i, int[][] pair, int prev, Integer[][] dp){
        if(i >= pair.length) return 0;

        if(dp[prev+1][i] != null) return dp[prev+1][i];

        if(prev == -1 || pair[i][1] >= pair[prev][1]){
            dp[prev+1][i] = Math.max(pair[i][1] + getBestTeam(i+1, pair, i, dp),  getBestTeam(i+1, pair, prev, dp));
            return dp[prev+1][i];
        }

        return dp[prev+1][i] = getBestTeam(i+1, pair, prev, dp);
    }
    
}