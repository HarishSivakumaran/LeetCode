class Solution {
    public boolean checkStrings(String s1, String s2) {
        char[] even = new char[26];
        char[] odd = new char[26];
        
        for(int i = 0; i < s1.length(); i++) {
            if(i%2 == 0) {
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;
            } else {
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(even[i] != 0 || odd[i] != 0) return false;
        }
        
        return true;
    }
}