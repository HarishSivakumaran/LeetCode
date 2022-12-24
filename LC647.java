// 647. Palindromic Substrings

class Solution {
    int strLen = 0, count = 0;
    public int countSubstrings(String s) {
        this.strLen = s.length();
        for(int i = 0; i < strLen; i++){
            //even
            checkForPal(s,i,i+1);

            //odd
            checkForPal(s,i,i);
        }

        return this.count;

    }

    void checkForPal(String s, int l ,int r){
        while (l >=0 && r < this.strLen){
            if(s.charAt(l) == s.charAt(r)){// pal
                this.count++;
                l--;
                r++;
            }else{
                return;
            }
        }
    }
}