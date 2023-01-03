// 17. Letter Combinations of a Phone Number

class Solution {

    char[][] keyBook = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
       
        if(digits.length() == 0) return out;

        combinations(digits, 0, out, "");

        return out;
    }

    public void combinations(String digits, int i, List<String> out, String curr){

        if(i == digits.length()){
            out.add(curr);
            return;
        }

        char[] currOpt = this.keyBook[digits.charAt(i)-'0'];

        for(char a : currOpt){
            curr = curr + a;
            combinations(digits, i+1, out, curr);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}