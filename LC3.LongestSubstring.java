class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet();
        char[] arr = s.toCharArray();
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            while (set.contains(arr[i])) {
                set.remove(arr[l++]);
            }
            set.add(arr[i]);
            max = Math.max(max, i - l + 1);
        }

        return max;

    }
}