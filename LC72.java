// 72. Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {

        if(word1.length()==0) return word2.length();

        if(word2.length()==0) return word1.length();

        int[][] maxOp = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i <= word1.length(); i++){ // filling last col
            maxOp[i][word2.length()] = word1.length() - i;
        }
        for(int i = 0; i <= word2.length(); i++){// filling last row
            maxOp[word1.length()][i] = word2.length() - i;
        }

        for(int i = word1.length()-1; i >=0; i--){
            for(int j = word2.length()-1; j >=0; j--){
                if(word1.charAt(i) == word2.charAt(j) ){
                    //matched no operations to do
                    maxOp[i][j] = maxOp[i+1][j+1];
                } else{
                   maxOp[i][j] = 1 + Math.min(maxOp[i+1][j+1], Math.min(maxOp[i+1][j], maxOp[i][j+1])); //Replace, Delete, Insert
                }         
            }
        }

        return maxOp[0][0];
    }
}