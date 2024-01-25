class Solution {
    Integer[][] cache = null;
    public int longestCommonSubsequence(String text1, String text2) {
        cache = new Integer[text1.length()+1][text2.length()+1];
        return getMax(text1, text2, 0, 0);
    }

    private int getMax(String text1, String text2, int i, int j) {
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(cache[i][j] != null) return cache[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            return cache[i][j] = 1 + getMax(text1, text2, i+1, j+1);
        }  else {
            return cache[i][j] = Math.max(getMax(text1, text2, i+1, j) , getMax(text1, text2, i, j+1));
        }
    }

}