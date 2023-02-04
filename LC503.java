// 503. Next Greater Element II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] out = new int[nums.length];
        Stack<Integer> stack = new Stack();
        int j = 2;
        while (j > 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                while (stack.size() > 0 && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (stack.size() > 0 && stack.peek() > nums[i]) {
                    out[i] = stack.peek();
                } else {
                    out[i] = -1;
                }
                stack.push(nums[i]);
            }
            j--;
        }

        return out;

    }
}