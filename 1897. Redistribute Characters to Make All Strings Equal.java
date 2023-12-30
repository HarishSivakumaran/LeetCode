class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
       for(String w : words) {
           for(int i = 0; i < w.length(); i++) count[w.charAt(i)-'a']++;
       }

       for(int n : count) if(n%words.length != 0) return false;
       return true;
    }
}