// 1143. Longest Common Subsequence

// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcs = new int[text1.length()][text2.length()];
        int i1 = 0, i2 = 0;
        traverse(text1, text2, i1, i2, lcs );
        return lcs[0][0];
    }

    public int traverse(String text1, String text2, int i1, int i2, int[][] lcs ){
        if(i1 >= text1.length() || i2 >= text2.length()) return 0;

        if(lcs[i1][i2] != 0) return lcs[i1][i2];

        if(text1.charAt(i1) == text2.charAt(i2)){
           lcs[i1][i2] = 1 + traverse(text1, text2, i1+1, i2+1, lcs );
        }else{
           lcs[i1][i2] = Math.max(traverse(text1, text2, i1+1, i2, lcs ), traverse(text1, text2, i1, i2+1, lcs ));
        }

        return lcs[i1][i2];
    }
}