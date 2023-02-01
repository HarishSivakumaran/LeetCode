// 415. Add Strings

class Solution {
    public String addStrings(String num1, String num2) {
        int[] out = new int[Math.max(num1.length(), num2.length())+1];

        if(num1.length() < num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        n1.reverse();
        n2.reverse();

        for(int i = 0; i < n1.length(); i++){
            int j = 0;
            if(i < n2.length()){
                j = n2.charAt(i) - '0';
            }
            out[i] += (n1.charAt(i) - '0') + j;
            out[i+1] += out[i]/10;
            out[i] %= 10;
        }

        int start = out.length-1;
        while(start > 0 && out[start] == 0) start--;

        n1.setLength(0);
        while(start >= 0) n1.append(out[start--]);

        return n1.toString();
        
    }
}