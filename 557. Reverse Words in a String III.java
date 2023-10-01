class Solution {
    public String reverseWords(String s) {
        char[] word = s.toCharArray();
        int l = 0, r = 0;

        while(l < word.length) {
            while(r < word.length && word[r] != '\s') r++;
            int left = l, right = r-1;
            while(left < right) {
                char temp = word[left];
                word[left++] = word[right];
                word[right--] = temp;
            }
            l = r+1; r = l;
        }
        return new String(word);
    }
}