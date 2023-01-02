// 131. Palindrome Partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList();
        subPalindrome(s, 0, new ArrayList(), out);
        return out;       
    }
    
    public void subPalindrome(String w, int s, List<String> curr, List<List<String>> out){
        if(s >= w.length()){
            out.add(new ArrayList(curr));
        }else{           
            for(int i = s; i < w.length(); i++){
                String currS = w.substring(s, i+1);
                if(isPalin(currS)){ 
                    curr.add(currS);
                    subPalindrome(w, i+1, curr, out);
                    curr.remove(curr.size()-1);
                }else{
                    continue;
                }
            }
        }

    }

    public boolean isPalin(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}