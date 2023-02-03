// 459. Repeated Substring Pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int l = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            String currSub = s.substring(0, i + 1);

            if (s.length() % currSub.length() != 0)
                continue;

            int jump = currSub.length(), j = jump;

            while (j < s.length() && currSub.equals(s.substring(j, j + jump))) {
                j += jump;
                if (j == s.length())
                    return true;
            }
        }

        return false;

    }
}