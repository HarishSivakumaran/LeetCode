class Solution {
    public String firstPalindrome(String[] words) {
        for(String w : words) {
            if(isPal(w)) return w;
        }

        return "";
    }

    private boolean isPal(String s) {
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}