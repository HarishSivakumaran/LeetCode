// 541. Reverse String II

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int jump = Math.min(k, s.length() - 1);

        for (int i = 0; i < s.length(); i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, s.length() - 1);
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }

        return new String(chars);

    }
}