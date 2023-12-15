class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> outdegree = new HashMap();
        HashSet<String> all = new HashSet();
        for(List<String> path : paths) {
            outdegree.put(path.get(0), outdegree.getOrDefault(path.get(0), 0)+1);
            all.add(path.get(0));
            all.add(path.get(1));
        }

        for(String s : all) {
            if(outdegree.getOrDefault(s, -1) == -1) return s;
        }

        return "";
    }
}