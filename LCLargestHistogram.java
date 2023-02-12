class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int[] curr = null;
        int max = -1, i = 0;
        for (; i < heights.length; i++) {
            int minPos = i;
            while (stack.size() > 0 && stack.peek()[1] >= heights[i]) {
                curr = stack.pop();
                max = Math.max(max, curr[1] * (i - curr[0]));
                minPos = curr[0];
            }
            stack.push(new int[] { minPos, heights[i] });
        }

        while (stack.size() > 0) {
            curr = stack.pop();
            max = Math.max(max, curr[1] * (i - curr[0]));
        }

        return max;
    }
}