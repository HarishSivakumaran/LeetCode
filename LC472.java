// 472. Concatenated Words

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> out = new ArrayList();
        HashSet<String> hs = new HashSet();

        for(String word : words){
            hs.add(word);
        }

        for(int i = 0; i < words.length; i++){
            
            String curr = words[i];
            boolean[] bConcatWord = new boolean[curr.length()+1];
            bConcatWord[bConcatWord.length-1] = true;

           for(int j = curr.length() - 1; j >= 0 && !bConcatWord[j]; j--){
               for(int k = j+1; !bConcatWord[j] && k <= curr.length(); k++){
                   if(!(j == 0 && k == curr.length()) &&hs.contains(curr.substring(j, k))){
                       bConcatWord[j] = bConcatWord[k];
                   }
               }
            }

            if(bConcatWord[0]) out.add(curr);
            
        }  

        return out;      
    }
}