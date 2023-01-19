// 44. Wildcard Matching

class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return checkMatching(s ,p ,0, 0, dp);
    }

    public boolean checkMatching(String s, String p, int i, int j,  Boolean[][] dp ){

        if(i >= s.length() && j >= p.length()) return true;

        if(j >= p.length()) return false;

        if(dp[i][j] != null) return dp[i][j];

        boolean isMatched = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' ||p.charAt(j) == '*');


        if(p.charAt(j) == '*'){
            isMatched = (checkMatching(s, p, i, j+1, dp) || (isMatched && checkMatching(s,p,i+1, j, dp)) || (isMatched &&           checkMatching(s,p,i+1, j+1, dp)));
        }else{       
            isMatched = isMatched && checkMatching(s,p,i+1, j+1, dp);
        }   

        dp[i][j] = isMatched;     

        return isMatched;
    }
}