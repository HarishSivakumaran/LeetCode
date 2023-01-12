// 58. Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        int r = s.length()-1;

        while(s.charAt(r) == ' '){
            r--;
        }

        int c = 0;

        while(r >= 0 && s.charAt(r) != ' '){
            c++;
            r--;
        }     

        return c;   
    }
}