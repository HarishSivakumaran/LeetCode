class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Stack<Character> stack = new Stack();
        Stack<Character> stack2 = new Stack();
        for(int i = 0; i < Math.max(s1.length, s2.length); i++) {
            if(i < s1.length){
                if(s1[i] == '#') {
                    if(!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(s1[i]);
                }
            }

            if(i < s2.length){
                if(s2[i] == '#') {
                    if(!stack2.isEmpty()) stack2.pop();
                } else {
                    stack2.push(s2[i]);
                }
            }
        }

        if(stack.size() != stack2.size()) return false;

        while(stack.size() > 0) {
            if(stack.peek() != stack2.peek()) return false;
            stack.pop();
            stack2.pop();
        }

        return true;
    }
}