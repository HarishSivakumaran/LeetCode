class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] count = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        int[][] countTillIndex = new int[s.length()][26];
        boolean[][] added = new boolean[26][26];
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            for(int j = 0; j < 26; j++) {
                countTillIndex[i][j] = count[j];
            }  

            if(lastIndex[s.charAt(i)-'a'] != -1) {
                for(int j = 0; j < 26; j++) {
                    if(countTillIndex[i-1][j]
                      -countTillIndex[lastIndex[s.charAt(i)-'a']][j] > 0) {
                          if(added[s.charAt(i)-'a'][j]) continue;
                          added[s.charAt(i)-'a'][j] = true;
                          ans++;
                    }
                }
            }

            lastIndex[s.charAt(i)-'a'] = i;          
        }

        for(int n : count) if(n >= 3) ans++;
        return ans;
    }
}