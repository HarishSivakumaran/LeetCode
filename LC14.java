// 14. Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){
            prefix = findprefix(prefix, strs[i]);
            if(prefix.length() == 0) return "";
        }

        return prefix;
        
    }

    public String findprefix(String a, String b){
        int l = 0;

        while(l < a.length() && l < b.length()){
            if(a.charAt(l) == b.charAt(l)){ 
                l++; 
                continue;
            }
            return a.substring(0,l);
        }
        return a.substring(0,l);
    }
}