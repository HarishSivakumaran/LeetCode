class Solution {
    public int minExtraChar(String s, String[] words) {
        int[] charsToBDel = new int[s.length()+1];
        Arrays.fill(charsToBDel, Integer.MAX_VALUE);
        charsToBDel[charsToBDel.length-1] = 0;

        for(int i = s.length()-1; i >= 0; i--) {
            // let's check if anythig is matching
            for(String w : words) {
                if(s.substring(i, Math.min(i+w.length(), s.length())).equals(w)) {
                    charsToBDel[i] = Math.min(charsToBDel[i], charsToBDel[i+w.length()]);
                }
            }

            //try deleting and check 
            charsToBDel[i] = Math.min(charsToBDel[i], 1 + charsToBDel[i+1]);
        }

        return charsToBDel[0];
    }
}