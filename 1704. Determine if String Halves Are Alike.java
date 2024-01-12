class Solution {
    public boolean halvesAreAlike(String s) {
        int vow = 0, l = 0, r = s.length()-1;
        while(l < r) {
            if(isVowel(s.charAt(l++)))vow++;
            if(isVowel(s.charAt(r--)))vow--;
        }

        return vow == 0;

    }
    private boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
               a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }
}