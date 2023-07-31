class Solution {
    Integer[][] cache = null;
    public int minimumDeleteSum(String s1, String s2) {
        cache = new Integer[s1.length()+1][s2.length()+1];
        return LongestCommonSubsequenceVariation(s1, s2, 0, 0);
    }

    private int LongestCommonSubsequenceVariation(String s1, String s2,
    int i, int j ) {
        if(cache[i][j] != null) return cache[i][j];

        if(i >= s1.length() || j >= s2.length()) {
            int sum = 0;
            for(int k = i; k < s1.length(); k++) sum += ((int)s1.charAt(k));
            for(int k = j; k < s2.length(); k++) sum += ((int)s2.charAt(k));
            return cache[i][j] =  sum;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = LongestCommonSubsequenceVariation(s1, s2, i+1, j+1);
        } else {
            return cache[i][j] = Math.min(
            ((int)(s1.charAt(i)) 
            + LongestCommonSubsequenceVariation(s1, s2, i+1, j)),
            ((int)s2.charAt(j)) 
            + LongestCommonSubsequenceVariation(s1, s2, i, j+1)
            );
        }
    }
}