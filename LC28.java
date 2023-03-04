// 28. Find the Index of the First Occurrence in a String

class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        if (needle.length() == haystack.length())
            return needle.equals(haystack) ? 0 : -1;

        // KMP algorithm
        int[] lps = new int[needle.length()];
        int prevLpsPointer = 0, i = 1, j = 0;

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(prevLpsPointer)) {
                lps[i] = prevLpsPointer + 1;
                i++;
                prevLpsPointer++;
            } else if (prevLpsPointer == 0) {
                lps[i++] = 0;
            } else {
                prevLpsPointer = lps[prevLpsPointer - 1];
            }
        }

        i = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == needle.length())
                return i - needle.length();
        }

        return -1;

    }

}