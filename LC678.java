// 678. Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            switch(curr){
                case '(': minOpen++; maxOpen++;
                 break;
                case ')': if(minOpen > 0) minOpen--;
                maxOpen--;
                break;
                case '*': if(minOpen > 0) minOpen--;
                maxOpen++;;
                break;
            }
            if(maxOpen < 0) return false;       
    }

        return minOpen == 0;
    }

}