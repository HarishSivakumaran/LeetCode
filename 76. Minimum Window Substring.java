class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int[] count = new int[100];
        int ansL = 0, ansR = s.length()+5;
        int exp = t.length();

        for (int i = 0; i < exp; i++) {
            count[t.charAt(i) - 'A']++;
        }

        int l = 0, r = 0;
        while (r < s.length()) {
            char curr = s.charAt(r);
            if (count[curr - 'A'] > 0) {
                exp--;
            }
            count[curr - 'A']--;

            while (exp == 0) {
                if ((ansR-ansL+1) > (r - l + 1)) {
                    ansL = l;
                    ansR = r;
                }
                count[s.charAt(l) - 'A']++;
                if (count[s.charAt(l++) - 'A'] > 0)
                    exp++;
            }

            r++;

        }

        return (ansR-ansL+1) > s.length() ? "" : s.substring(ansL, ansR+1);

    }
}