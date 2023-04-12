// 71. Simplify Path

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] arr = path.split("\\/");

        for (String s : arr) {
            if (s.equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
                continue;
            }
            if (s.equals("."))
                continue;

            if (s.length() > 0)
                stack.push(s);
        }

        String res = "";

        while (stack.size() > 0) {
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }
}