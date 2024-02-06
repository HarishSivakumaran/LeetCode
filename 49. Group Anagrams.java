class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap();
        List<List<String>> ans = new ArrayList();

        for(String s : strs) {
            char[] c = new char[26];
            for(int i = 0; i < s.length(); i++) c[s.charAt(i)-'a']++;
            String key = new String(c);
            if(groups.containsKey(key)) {
                groups.get(key).add(s);
            } else {
                List<String> out = new ArrayList();
                out.add(s);
                ans.add(out);
                groups.put(key, out);
            }
        }

        return ans;
    }
}