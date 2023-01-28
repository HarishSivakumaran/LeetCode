// 389. Find the Difference

class Solution {
    public char findTheDifference(String s, String t) {
        int[] alpha = new int[26];
        for(int i = 0; i < t.length(); i++){
            alpha[t.charAt(i)-'a']++;
            if(i < s.length()){
                alpha[s.charAt(i)-'a']--;
            }
        } 

        for(int i = 0; i < 26; i++){
            if(alpha[i] != 0) return (char) ('a'+i);
        }    

        return 'a';   
    }
}