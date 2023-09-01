class Solution {
    String[][] cache = null;
    public String shortestCommonSupersequence(String str1, String str2) {
        cache = new String[str1.length()][str2.length()];
        return getShortest(str1, str2, 0, 0);
    }

    private String getShortest(String s1, String s2, int i, int j) {
        if(i >= s1.length()) return s2.substring(j, s2.length());
        if(j >= s2.length()) return s1.substring(i, s1.length());


        if(cache[i][j] != null) return cache[i][j];


        if(s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = s1.charAt(i) + getShortest(s1, s2, i+1, j+1);
        } else {
            String op1 = s1.charAt(i) + getShortest(s1, s2, i+1, j);
            String op2 = s2.charAt(j) + getShortest(s1, s2, i, j+1);
            if(op1.length() < op2.length()) {
                return cache[i][j] = op1;
            } else {
                return cache[i][j] = op2;
            }
        }
    }
}