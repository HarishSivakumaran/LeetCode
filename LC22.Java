// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        char[] curr = new char[n*2];
        curr[0] = '(';
        perValidPar(out, curr, 1, 0, n*2);
        return out;

    }

    public void perValidPar(List<String> out, char[] curr, int o, int c, int t){
        if(o+c == t){
            out.add(new String(curr));
            return;
        }

        if(o < t/2){
            curr[o+c] = '(';
            o++;
            perValidPar(out, curr, o, c, t);
            o--;
            curr[o+c] = '#';
        }

        if(c < t/2 && o > c){
            curr[o+c] = ')';
            c++;
            perValidPar(out, curr, o, c, t);
            c--;
            curr[o+c] = '#';
        }


    }
}

