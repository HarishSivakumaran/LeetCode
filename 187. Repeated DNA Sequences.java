class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = 0, r = 0;
        HashMap<String, Integer> count = new HashMap();
        String key = "";
        List<String> out = new ArrayList();

        while(r < s.length()){
            if(r-l+1 == 10){
                key = s.substring(l, r+1);
                count.put(key, count.getOrDefault(key, 0)+1);
                if(count.get(key) == 2) out.add(key);
                l++;
            }
            r++;
        }

        return out;
    }
}