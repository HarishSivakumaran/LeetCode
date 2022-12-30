// 76. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {    
        if(t.length() > s.length())  return "";

        HashMap<Character, Integer> hmT = new HashMap<>();
        HashMap<Character, Integer> hmS = new HashMap<>();

        String res = null;
        boolean noMatch = true;

        for(int i = 0; i < t.length(); i++){
            hmT.put(t.charAt(i), 1 + hmT.getOrDefault(t.charAt(i), 0));
        }

        int need = t.length(), have = 0;
        int l = 0;
        for(int j = 0; j < s.length(); j++){
            char curr = s.charAt(j);
            hmS.put(curr, 1 + hmS.getOrDefault(curr, 0));
            if(hmT.containsKey(curr) && hmS.get(curr) > 0 &&  hmT.get(curr) > 0 && hmS.get(curr) <= hmT.get(curr)){
                have ++;
            }

            while(have == need){
                res = res != null && res.length() < j - l + 1 ? res : s.substring(l , j+1);
                noMatch = false;
                char left = s.charAt(l);
                hmS.put(left, hmS.getOrDefault(left, 0) - 1);
                if(hmT.containsKey(left) && hmT.get(left) > hmS.get(left)){
                 have--;
                }
                l++;
            }
            }
 
            return noMatch ? "" : res;

        }

}