class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> losses = new HashMap();
        for(int[] m : matches) {
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0)+1);
        }
        List<List<Integer>> out = new ArrayList(2);
        out.add(new ArrayList());
        out.add(new ArrayList());
        for(Map.Entry<Integer, Integer> entry : losses.entrySet()) {
            if(entry.getValue() == 0) out.get(0).add(entry.getKey()); 
            if(entry.getValue() == 1) out.get(1).add(entry.getKey()); 
        }

        Collections.sort(out.get(0));
        Collections.sort(out.get(1));

        return out;
    }
}