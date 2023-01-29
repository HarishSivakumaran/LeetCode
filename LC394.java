// 394. Decode String

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        StringBuilder out = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == ']'){
                // create string
                StringBuilder sub = new StringBuilder();
                StringBuilder newStr = new StringBuilder();
                while(!stack.peek().equals("["))sub.append(stack.pop());
                stack.pop(); //remove the opening bracket
                int rep = Integer.parseInt(stack.pop());

                for(int j = 0;j < rep; j++){
                    newStr.append(sub);
                }
                stack.push(newStr.toString());
            }else{

                if(curr-'0' >= 0 && curr-'0' < 10){
                    num.append(curr);
                    continue;
                }else if(num.length() > 0){
                    stack.push(num.toString());
                    num.setLength(0);
                }               
                stack.push(String.valueOf(curr));
                
            }
        }

        while(stack.size()> 0)out.append(stack.pop());

        return out.reverse().toString();
        

        
    }
}