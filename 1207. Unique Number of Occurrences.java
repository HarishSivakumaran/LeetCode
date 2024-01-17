class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap();
        for(int n : arr) {
            count.put(n, count.getOrDefault(n, 0)+1);
        }

        HashSet<Integer> set = new HashSet();
        for(int n : count.values()) {
            if(set.contains(n)) return false;
            set.add(n);
        }

        return true;
    }
}