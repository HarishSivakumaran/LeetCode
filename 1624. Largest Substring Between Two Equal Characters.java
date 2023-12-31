class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        int ans = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(firstOccur[c-'a'] == -1) {
                firstOccur[c-'a'] = i;
            } else {
                ans = Math.max(ans, i-firstOccur[c-'a']-1);
            }
        }

        return ans;
    }
}