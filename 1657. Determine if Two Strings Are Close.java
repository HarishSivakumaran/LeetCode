class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] count1 = new int[26], count2 = new int[26];
        for(int i = 0;  i < word1.length(); i++) {
            count1[word1.charAt(i) -'a']++;
            count2[word2.charAt(i) -'a']++;
        }
        HashMap<Integer, Integer> marker = new HashMap();
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]) {
                if(count1[i] == 0 || count2[i] == 0) return false;
                marker.put(count1[i], marker.getOrDefault(count1[i], 0)+1);
                marker.put(count2[i], marker.getOrDefault(count2[i], 0)-1);
            }
        }

        for(int n : marker.values()) if(n != 0) return false;
        return true;
    }
}