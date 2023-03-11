// 1963. Minimum Number of Swaps to Make the String Balanced

class Solution {
    public int minSwaps(String s) {
        int open = 0, closed = 0, unbalance = 0;

        for (char a : s.toCharArray()) {
            if (a == '[') {
                open++;
            } else {
                if (open > closed) {
                    closed++;
                } else {
                    unbalance++;
                }

            }
        }

        return (unbalance + 1) / 2;
    }
}