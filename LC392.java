// 392. Is Subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;

        if(s.length() == 0) return true;

        int i1 = 0;

        for(int j = 0; j < t.length(); j++){
            if(s.charAt(i1) == t.charAt(j)) i1++;
            if(i1 >= s.length()) break;
        }

        return i1 >= s.length();
        
    }
}