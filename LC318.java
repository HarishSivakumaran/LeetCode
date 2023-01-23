// 318. Maximum Product of Word Lengths

class Solution {
    public int maxProduct(String[] words) {
        int[] bitMask = new int[words.length];

        for(int j = 0; j < words.length; j++){
            int mask = 0;
            String word = words[j];
            for(int i = 0; i < word.length(); i++){
                mask |= 1 << (word.charAt(i)-'a');
            }
            bitMask[j] = mask;
        }

        int max = 0;

        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                if((bitMask[i] & bitMask[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
            }
        }

        return max;
            
    }
}