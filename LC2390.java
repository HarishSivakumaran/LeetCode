// 2390. Removing Stars From a String
class Solution {
    public String removeStars(String s) {
        char[] outStr = new char[s.length()];
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (j >= 0)
                    outStr[j--] = Character.MIN_VALUE;
                continue;
            }
            outStr[++j] = s.charAt(i);
        }

        if (j < 0)
            return "";

        return new String(outStr).substring(0, j + 1);

    }
}