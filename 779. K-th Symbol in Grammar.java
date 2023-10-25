class Solution {
    public int kthGrammar(int n, int k) {
        return dfs((int)Math.pow(2, n) + (k-1), n);   
    }

    private int dfs(int from, int row) {
        if(row == 1) return 0;

        int parent = dfs(from/2, row-1);
        
        if(parent == 1) {
            return from%2 == 0 ? 1 : 0; 
        } else {
            return from%2 != 0 ? 1 : 0; 
        }
    }
}


/*
class Solution {
    public int kthGrammar(int n, int k) {
        k--;
        StringBuilder currRow = new StringBuilder("0");
        for(int r = 1; r < n; r++) {
            StringBuilder newRow = new StringBuilder();
            for(int i = 0; i < currRow.length(); i++) {
                if(currRow.charAt(i) == '0') {
                    newRow.append("01");
                } else {
                    newRow.append("10");
                }
            }
            currRow = newRow;
        }

        return (int)(currRow.charAt(k)-'0');
    }
}
*/