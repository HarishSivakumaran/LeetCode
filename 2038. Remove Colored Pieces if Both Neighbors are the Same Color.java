class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        char[] word = colors.toCharArray();
        for(int i = 1; i < word.length-1; i++) {
            if(word[i] == 'A' && 
            word[i-1] == 'A' && word[i+1] == 'A') {
                alice++;
            } else

            if(word[i] == 'B' && 
            word[i-1] == 'B' && word[i+1] == 'B') {
                bob++;
            }
        }

        return alice > bob;
    }
}