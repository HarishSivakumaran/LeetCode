// 5. Longest Palindromic Substring

class Solution {
    String res = "";
    public String longestPalindrome(String s) {

        this.res = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
                //even
                isPallindrome(s,i,i+1);
                //odd
                isPallindrome(s,i,i);
        }
        return this.res;
        
    }

    void isPallindrome(String s, int l, int r){

        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){ // pallindrome
              if(res.length() < r-l +1 ){
                  res = s.substring(l,r+1);
              }
              l--;
              r++;
            }else{
                return;
            }
      
        }
    
    }
}