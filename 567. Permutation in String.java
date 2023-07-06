class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int unMatched = s1.length();
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)-'a']++;

        int l = 0, r = 0;
        while(r < s1.length()){
            if(count[s2.charAt(r)-'a'] > 0){
                unMatched--;
            }
            count[s2.charAt(r++)-'a']--;
        }
        if(unMatched == 0) return true;

        r--;
        while(r < s2.length()-1){
            //increment l
            count[s2.charAt(l)-'a']++;
            if(count[s2.charAt(l++)-'a'] > 0) unMatched++;

            //increment r
            r++;
            if(count[s2.charAt(r)-'a'] > 0) unMatched--;
            count[s2.charAt(r)-'a']--;

            if(unMatched == 0) return true;

        }

        return false;
    }
}