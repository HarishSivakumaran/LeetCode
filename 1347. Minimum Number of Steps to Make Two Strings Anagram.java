class Solution {
    public int minSteps(String s, String t) {
        int[] misMatches = new int[26];
        for(int i = 0; i < s.length(); i++) {
            misMatches[s.charAt(i)-'a']++;
            misMatches[t.charAt(i)-'a']--;
        }

        int ans = 0;
        for(int n : misMatches) ans += Math.abs(n);
        return ans/2;
    }
}