class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String t : tokens) {
            switch(t) {
                case "+": 
                stack.push(stack.pop()+stack.pop());
                break;
                case "-": 
                stack.push(-(stack.pop())+(stack.pop()));
                break;
                case "*": 
                stack.push((stack.pop())*(stack.pop()));
                break;
                case "/": 
                int div = (stack.pop());
                stack.push((stack.pop())/div);
                break;
                default: stack.push(Integer.parseInt(t));
            }
        }

        return stack.peek();
    }
}