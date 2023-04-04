// 2405. Optimal Partition of String

class Solution {
    public int partitionString(String s) {
        int ans = 1;
        HashSet<Character> set = new HashSet();
        int l = 0, r = 0;

        for (; r < s.length(); r++) {
            if (set.contains(s.charAt(r))) {
                l = r;
                set.clear();
                ans++;
            }

            set.add(s.charAt(r));
        }

        return ans;
    }
}