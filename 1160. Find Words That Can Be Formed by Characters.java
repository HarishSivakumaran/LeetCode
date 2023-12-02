class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;

        int[] target = getCount(chars);
        for(String s : words) {
            int[] req = getCount(s);
            boolean doable = true;
            for(int i = 0; i < 26; i++) {
                if(req[i] > target[i]) {
                    doable = false;
                    break;
                }
            }
            if(doable) ans += s.length();
        }

        return ans;
    }

    private int[] getCount(String chars) {
        int[] count = new int[26];
        char[] arr = chars.toCharArray();
        for(char c : arr) {
            count[c-'a']++;
        }

        return count;
    }
}