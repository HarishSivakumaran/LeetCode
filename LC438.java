// 438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList();
        if (p.length() > s.length())
            return out;
        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[p.charAt(i) - 'a']++;
        }
        if (checkMatch(count)) {
            out.add(0);
        }

        int l = 0, r = p.length() - 1;

        while (r < s.length() - 1) {
            count[s.charAt(l++) - 'a']++;
            count[s.charAt(++r) - 'a']--;
            if (checkMatch(count)) {
                out.add(l);
            }
        }

        return out;
    }

    public boolean checkMatch(int[] count) {
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }
}