// 946. Validate Stack Sequences
// // 

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length != popped.length)
            return false;

        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (stack.size() > 0 && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}