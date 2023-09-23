class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        int[] dp = new int[words.length];
        int maxAns = 0;

        for(int i = words.length-1; i >= 0; i--) {
            int max = 0;
            for(int j = i+1; 
                    j < words.length && words[j].length() <= words[i].length()+1;
                    j++) {
                if(words[j].length() == words[i].length()+1 && 
                   isSuccessor(words[i], words[j])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1+max;
            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }

    private boolean isSuccessor(String pred, String succ) {
        int i = 0;
        for(int j = 0; j < succ.length() && i < pred.length(); j++) {
            if(pred.charAt(i) == succ.charAt(j)) i++;
        }

        return i == pred.length();
    }
}