// 214. Shortest Palindrome

class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder resS = new StringBuilder(s+s);
        for(int i = s.length()/2; i >= 0; i--){
            int res = requiredString(i , i, s); //odd
            StringBuilder posRes = null;

            if(res != -1){
                posRes = new StringBuilder(s.substring(res, s.length())).reverse().append(s);
                if(posRes.length() < resS.length()) resS = posRes;
            }

            res = requiredString(i , i+1, s); //even

              if(res != -1){
                posRes = new StringBuilder(s.substring(res, s.length())).reverse().append(s);
                if(posRes.length() < resS.length()) resS = posRes;
            }

            if(posRes != null) break;

        }

        return resS.toString();
        
    }

    public int requiredString(int l, int r, String s){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }else{
                return -1;
            }
        }

        if(l < 0) return r;
        
        return -1;
    }
}