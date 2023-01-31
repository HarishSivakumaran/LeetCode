// 409. Longest Palindrome

class Solution {
    int max = 0;
    public int longestPalindrome(String s) {
        int[] count = new int[26];
        int[] countU = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)-'a' >=0 && s.charAt(i)-'a' < 27)
                count[s.charAt(i)-'a']++;
            else
                countU[s.charAt(i)-'A']++;

        }  

        boolean isOdd = false;

        for(int i = 0; i < 26; i++){
            if(count[i] % 2 == 0){ 
                max += count[i];
            }else{
                max += (count[i]-1);
            }
            if(countU[i] % 2 == 0){ 
                max += countU[i];
            } else{
                max += countU[i]-1;
            }
            if(count[i] % 2 != 0) isOdd = true;
            if(countU[i] % 2 != 0) isOdd = true;
        }   

        return isOdd ? max+1 : max;   
        
    }

}