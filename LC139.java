// 139. Word Break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        dp[dp.length-1] = true;
        for(int i = s.length()-1; i >=0; i-- ){
            for(String w : wordDict){
                if(i + w.length() <= s.length() && (
                    s.substring(i, i + w.length()).startsWith(w)
                )){
                    dp[i] = dp[i + w.length() ];
                }

                if(dp[i]) break;
            }
        }

        return dp[0];
    }
}