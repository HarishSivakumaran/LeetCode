// 10. Regular Expression Matching

class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        return checkMatch(s, p ,0, 0, dp);    
    }

    public boolean checkMatch(String s, String p, int i, int j, boolean[][] dp){

        if(i >= s.length() && j >= p.length()) return true;

        if(j >= p.length()) return false;

        if(dp[i][j]) return true;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            dp[i][j] = (checkMatch(s, p ,i, j+2, dp)) || (match && checkMatch(s, p ,i+1, j, dp) );
        }else {
            dp[i][j] = match && checkMatch(s, p ,i+1, j+1, dp);
        }


        return dp[i][j];
    }
}