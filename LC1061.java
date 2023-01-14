// 1061. Lexicographically Smallest Equivalent String

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int[] p = new int[26];

        for(int i = 0; i < p.length; i++){
            p[i] = i;
        }

        for(int i = 0; i < s1.length(); i++){
            int rp1 = find(s1.charAt(i)-'a', p);
            int rp2 = find(s2.charAt(i)-'a', p);
            if(rp1 != rp2){ // union
                if(rp1 < rp2){
                    p[rp2] = rp1;
                }else{
                    p[rp1] = rp2;
                }
            }
            
        }

        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < baseStr.length(); i++){
            int j = find(baseStr.charAt(i)-'a', p);
            char k = (char)('a' + j);
            str.append(k);
        }  

        return str.toString();  
        
    }

    public int find(int i, int[] p){
        while(i != p[i]){
            p[i] = p[p[i]];
            i = p[i];
        }

        return i;
    }
}