// 115. Distinct Subsequences

class Solution {

    int[][] dir = {{0,1}, {1,0}};

    public int numDistinct(String s, String t) {
        if(t.length()==0) return 1;

        if(t.length() > s.length()) return 0;     

        int[][] dSubSeq = new int[s.length()+1][t.length()+1];   

        for(int i = 0; i < dSubSeq.length; i++){
            Arrays.fill(dSubSeq[i], -1);
        }

        dSubSeq[s.length()][t.length()] = 1;

        distictSubsequence(s, t, 0, 0, dSubSeq);

        return dSubSeq[0][0];

    }

    public int distictSubsequence(String s, String t, int i, int j, int[][] dSubSeq){

        if(i == dSubSeq.length-1 && j == dSubSeq[0].length-1) return 1;

        if(i >= s.length() ) return 0;

        if(j >= t.length() ) return 1;

        if(dSubSeq[i][j] > -1) return dSubSeq[i][j];

        int max = 0;

        if(s.charAt(i) == t.charAt(j)){
            max += distictSubsequence(s, t, i+1, j+1, dSubSeq);
        }
        max += distictSubsequence(s, t, i+1, j, dSubSeq);

        dSubSeq[i][j] = max;

        return dSubSeq[i][j];

    }
}