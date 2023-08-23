class Solution {
    public String reorganizeString(String s) {
        int max = 0; char maxChar = 0;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a'] > max) {
                max = count[s.charAt(i)-'a'];
                maxChar = s.charAt(i);
            }
        }

        if(max > (s.length()+1)/2) return "";

        int index = 0, start = 0;
        StringBuilder str = new StringBuilder(s);
        while(count[maxChar-'a'] > 0) {
            str.setCharAt(index, maxChar);
            count[maxChar-'a']--;
            index += 2;
            if(index >= s.length()) {
                start++;
                index = start;
            }
        }

        for(int i = 0; i < 26; i++) {
            while(count[i] > 0) {
                str.setCharAt(index, (char)(i+'a'));
                count[i]--;
                index += 2;
                if(index >= s.length()) {
                    start++;
                    index = start;
                }
            }
        }


        

        return str.toString();
    }
}