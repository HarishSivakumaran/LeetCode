// 1189. Maximum Number of Balloons

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] achar = new int[26];
        int[] cmp = new int[26];

        for(int i = 0; i < text.length(); i++){
            achar[text.charAt(i)-'a']++;
        } 

        int min = Integer.MAX_VALUE;

        String b = "balloon";

        for(int i = 0; i < b.length(); i++){
            cmp[b.charAt(i)-'a']++;
        } 

        for(int i = 0; i < b.length(); i++){
            if(achar[b.charAt(i)-'a'] < cmp[b.charAt(i)-'a']) return 0;
            min = Math.min(achar[b.charAt(i)-'a']/cmp[b.charAt(i)-'a'], min);
        } 

        return min;
        
    }
}