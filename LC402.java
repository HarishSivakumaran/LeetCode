// 402. Remove K Digits

class Solution {
    long min = Integer.MAX_VALUE;
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k == num.length()) return "0";
        // getMinDigit(0, num, new StringBuilder(), num.length()-k);
        Stack<Character> stack = new Stack();

        for(int i = 0; i < num.length(); i++){
            char curr = num.charAt(i);

            while(k > 0 && stack.size() > 0 && stack.peek() > curr){
                stack.pop();
                k--;
            }

            stack.push(curr);
        }

        while(k > 0){
             stack.pop();
             k--;
        }

        StringBuilder out = new StringBuilder();

        while(stack.size()>0) out.append(stack.pop());
        
        int count = out.length()-1;
        while(count > 0 && out.charAt(count) == '0')count--;

        out.replace(count+1, out.length(), "");

        return out.reverse().toString();
    }

    public void getMinDigit(int i, String num, StringBuilder val, int len){
        
        if(val.length() > len) return;

        if(val.length() == len){
            min = Math.min(min, Long.parseLong(val.toString()));
            return;
        }if( i < num.length()){
            int pos = val.length();
            val.append(num.charAt(i));
            getMinDigit(i+1, num, val, len);
            val.replace(pos, val.length(), ""); 
            getMinDigit(i+1, num, val, len);
        }
    }
}