// 524. Longest Word in Dictionary through Deleting
class Solution {
    String max = "";

    public String findLongestWord(String s, List<String> dictionary) {
        for (String w : dictionary) {
            if (w.length() >= max.length() && w.length() <= s.length()
                    && (hs.contains(w) || isSubSequence(s, w, 0, 0))) {
                if (w.length() == max.length()) {
                    for (int i = 0; i < max.length(); i++) {
                        if (w.charAt(i) - max.charAt(i) == 0)
                            continue;
                        if (w.charAt(i) - max.charAt(i) < 0) {
                            max = w;
                        }
                        break;
                    }
                } else {
                    max = w;
                }
            }
        }

        return max;

    }

    public boolean isSubSequence(String s, String c, int i, int j) {
        if (j >= c.length())
            return true;

        if (i >= s.length())
            return false;

        if (s.charAt(i) == c.charAt(j)) {
            return isSubSequence(s, c, i + 1, j + 1);
        }

        return isSubSequence(s, c, i + 1, j);
    }
}