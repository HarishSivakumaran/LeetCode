// 1930. Unique Length-3 Palindromic Subsequences

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            if (first[s.charAt(i) - 'a'] == -1)
                first[s.charAt(i) - 'a'] = i;
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        HashSet<Character> unique = new HashSet();

        for (int j = 0; j < 26; j++) {
            if (first[j] < last[j]) {
                unique.clear();
                for (int i = first[j] + 1; i < last[j]; i++) {
                    unique.add(s.charAt(i));
                }
                ans += unique.size();
            }
        }

        return ans;
    }
}