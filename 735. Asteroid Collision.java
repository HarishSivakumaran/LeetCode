class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int a : asteroids) {
            boolean dontAdd = false;
            while(stack.size() > 0 && isCollidable(stack.peek(), a)){
                if(Math.abs(a) == Math.abs(stack.peek())){
                    stack.pop();
                    dontAdd = true;
                    break;
                } else 
                if(Math.abs(a) > Math.abs(stack.peek())){
                    stack.pop();
                } else {
                    dontAdd = true;
                    break;
                }
            }
            if(!dontAdd)
                stack.push(a);
        }

        int[] out = new int[stack.size()];
        int i = out.length-1;
        while(i >= 0) {
            out[i--] = stack.pop();
        }

        return out;
    }

    private boolean isCollidable(int a, int b) {
        return a > 0 && b < 0;
    }
}