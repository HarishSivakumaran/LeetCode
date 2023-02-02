// 953. Verifying an Alien Dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] charIndex = new int[26];

        for (int i = 0; i < order.length(); i++) {
            charIndex[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int j = 0;
            for (; j < Math.min(curr.length(), next.length()); j++) {

                if (charIndex[curr.charAt(j) - 'a'] > charIndex[next.charAt(j) - 'a'])
                    return false;
                if (curr.charAt(j) - 'a' != next.charAt(j) - 'a')
                    break;
            }
            // check if next string have remaining, after complete match
            if (j == next.length() && curr.length() > j)
                return false;

        }

        return true;

    }
}