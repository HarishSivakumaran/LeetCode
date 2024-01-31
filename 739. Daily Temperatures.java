class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < t.length; i++) {
            while(stack.size() > 0 && t[stack.peek()] < t[i]) {
                int in = stack.pop();
                t[in] = i-in; 
            }
            stack.push(i);
        }

        while(stack.size() > 0) {
            t[stack.pop()] = 0;
        }

        return t;
    }
}