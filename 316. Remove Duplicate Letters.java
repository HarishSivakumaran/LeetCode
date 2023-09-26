class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] added = new boolean[26];
        char[] word = s.toCharArray();
        for(int i = 0; i < word.length; i++) count[word[i]-'a']++;
        int i = 0, insPtr = 0;
        while(i < word.length) {
            if(!added[word[i]-'a']){
                while(insPtr-1 >= 0 && count[word[insPtr-1]-'a'] > 0 && 
                    word[insPtr-1] > word[i]) {
                    added[word[insPtr-1]-'a'] = false;
                    word[insPtr-1] = Character.MIN_VALUE;
                    insPtr--;
                }

                added[word[i]-'a'] = true;
                char temp = word[i];
                word[i] = Character.MIN_VALUE;
                word[insPtr++] = temp;
                count[temp-'a']--;
            } else {
                count[word[i]-'a']--;
            }
            i++;
        }

        return new String(word).substring(0, insPtr);
    }
}