// 456. 132 Pattern
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack();
        int prevMin = Integer.MAX_VALUE;
        for (int n : nums) {
            while (stack.size() > 0 && stack.peek()[0] <= n)
                stack.pop();
            if (stack.size() > 0 && stack.peek()[1] < n)
                return true;
            stack.push(new int[] { n, prevMin });
            prevMin = Math.min(prevMin, n);
        }

        return false;
    }
}