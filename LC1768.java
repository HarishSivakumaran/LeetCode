// 1768. Merge Strings Alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }

        res.append(word1.substring(n, word1.length())).append(word2.substring(n, word2.length()));

        return res.toString();
    }
}