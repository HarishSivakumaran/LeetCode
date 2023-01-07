// 97. Interleaving String

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        return interLeaveString(s1,s2,s3,new int[s1.length()+1][s2.length()+1], 0, 0);
    }

    public boolean interLeaveString(String s1, String s2, String s3, int[][] possible, int i1,int i2){
        if(i1 > s1.length() || i2 > s2.length() ) return false;

        if(i1 == s1.length() && i2 == s2.length() ) return true;

        if(possible[i1][i2] != 0) return possible[i1][i2] == 1;

        boolean match1 = false, match2 = false;

        if(i1 < s1.length() && s3.charAt(i1+i2) == s1.charAt(i1)){
            match1 = interLeaveString(s1,s2,s3,possible, i1+1, i2);
        }

        if(!match1 && i2 < s2.length() && s3.charAt(i1+i2) == s2.charAt(i2)){
            match2 = interLeaveString(s1,s2,s3,possible, i1, i2+1);
        }

        possible[i1][i2] = ( match1 || match2 ) ? 1 : -1;

        return match1 || match2;


    }
}